package study.fileupload;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Hashtable;

public class SingleImageUpload {
	private static String DISPOSITION_PREFIX 	= "Content-Disposition:";
	private static String FILE_PREFIX 			= "filename=";
	public final static int NAMING_BY_INPUTNAME = 0;		// jsp에서의 <input type='file' ..>의 name값을 가지고  명명
	public final static int NAMING_BY_EXTERNAL	= 1;		// setFileName() 메소드로 설정한 이름을 가지고 명명
	public final static int NAMING_BY_LOCALNAME = 2;		// 로컬시스템에서의 파일명을 가지고 명명

	private String delimeter 	= null;						// 각 파라메터섹션을 구분하는 딜리미터
	private char separator		= '\\';						// 로컬 시스템의 파일 구분자(윈도우시스템 : \, 리눅스 /)
	private int naming 			= 0; 						// 저장될 파일이름의 명명 방법(0~2)
	private DataInputStream is 	= null;
	private String src_filename = null;						// 로컬 시스템에서의 파일 이름
	private String filename 	= null;						// 서버 시스템에 저장될 파일 이름
	private String root_directory 	= "/";					// 웹 루트디렉토리

	/* full_path = root_directory + relative_path(default_relative_path) */
	private String default_relative_path 	= "/";			// 디폴트 상대위치
	private String relative_path 			= null;			// '/dir1/dir2/' 의 형태
	private String full_path 				= null;			// '/dir1/dir2/' 의 형태로 파일이 저장되는 실제 디렉토리
	private Hashtable parameters 			= null;
	private String error_msg 				= "UPLOAD SUCCESS";
	private boolean success 				= true;
	private int filesize 					= 0;

	public SingleImageUpload(InputStream is){
		this.is 		= new DataInputStream(is);
		this.naming		= this.NAMING_BY_EXTERNAL;
		parameters = new Hashtable();
	}

	public SingleImageUpload(InputStream is,int naming){
		this.is 		= new DataInputStream(is);
		this.naming		= naming;
		parameters 		= new Hashtable();
	}

	public void setRelative_path(String path){
		this.relative_path = path;
	}

	public void setRoot_dircetory(String web_root){	// 2006.03.03 박경완
		this.root_directory = web_root;
	}

	public void setFilename(String filename){
		this.filename = filename;
	}

	public void setNaming(int rule){
		this.naming = rule;
	}

	public String getSrc_filename(){
		return src_filename;
	}

	public String getFilename(){
		return filename;
	}

	public String getRelative_path(){
		return relative_path;
	}

	public String getFull_path(){
		return full_path;
	}

	public String getdefault_relative_path(){
		return default_relative_path;
	}

	public String getParameter(String name){
		return (String)parameters.get(name);
	}

	public int getFilesize(){
		return filesize;
	}

	public String getError_msg(){
		return error_msg;
	}

	public boolean isSuccess(){
		return success;
	}

	public void start(){
		try {
			delimeter = is.readLine();
			String linedata = null;
			if ( is == null ) return;
			if (relative_path == null) relative_path = default_relative_path;

			while((linedata=is.readLine())!=null) {
			 	synchronized(linedata){
			 		if(linedata.indexOf(DISPOSITION_PREFIX)!=-1){
				 		if(linedata.indexOf(FILE_PREFIX)!=-1){
				 			receiveFileData(linedata);
				 		} else receiveParameterData(linedata);
				 	}
				}
			}
		}catch(Exception e){
			success = false;
			error_msg = "receiveParameter() " + e.getMessage();
			e.printStackTrace();
		}
	}

	private void receiveParameterData(String linedata){
		try	{
		 	int pos_s=linedata.lastIndexOf("=")+2;
     	 	int pos_e=linedata.lastIndexOf("\"");
		 	int line = 0;
		 	String paravalue ="";
   	 	 	String paraname ="";

   	 	 	paraname=linedata.substring(pos_s,pos_e);

   	 	 	is.readLine();

		 	while(true)	{
		 		 String temp=is.readLine();
		 	     if(temp==null)break;
         	     temp=new String(temp.getBytes("ISO-8859-1"),"Euc-kr");
         	     if(temp.indexOf(delimeter)!=-1&&!temp.equals("\n"))break;
		 		 line ++;

				if(line==1) paravalue+=temp;
				else paravalue+="\n"+temp;
         	}
		 	parameters.put(paraname,paravalue);
		 }catch(Exception e){
			 success = false;
			 error_msg = "receiveParameterData() " + e.getMessage();
			 e.printStackTrace();
		 }
	}

	private void receiveFileData(String linedata) {
		FileOutputStream fos = null;

		try {
			String file_ext = "";
			int pos_s = linedata.indexOf("=")+2;
			int pos_e = linedata.lastIndexOf("\";");

			String input_name = linedata.substring(pos_s,pos_e);

			full_path = root_directory + relative_path;
			File dir = new File(full_path);
			if ( !dir.exists() ) {
				if ( !dir.mkdirs() ) throw new Exception("Diretory Make Failed!!");
			}

			String localname = "";
			pos_s = linedata.lastIndexOf("=\"")+2;
			pos_e = linedata.lastIndexOf("\"");
			localname = linedata.substring(pos_s,pos_e);
			this.src_filename = localname.substring(localname.lastIndexOf(separator));
			file_ext = localname.substring(localname.lastIndexOf('.')).toLowerCase();

			switch (this.naming){
			case NAMING_BY_INPUTNAME:
				filename = input_name + file_ext;
				break;
			case NAMING_BY_EXTERNAL:
				filename = filename + file_ext;
				break;
			case NAMING_BY_LOCALNAME:
				filename = src_filename;
				break;
			default:
				filename = input_name + file_ext;	//NAMING_BY_INPUTNAME
			}

			if(filename.length()<50&&filename.indexOf(".")!=-1){
				filename = new String(filename.getBytes("ISO-8859-1"),"Euc-kr");

				is.readLine();
				is.readLine();

				fos = new FileOutputStream(full_path+filename);

				byte[] buffer = new byte[1024];
				byte ch;

				int x=0;
				int size=0;

				while(true){
					size++;

					buffer[x++] = ch = is.readByte();
					if(x==delimeter.length()+1){
						 int y=0;
						 String end2=new String(buffer,0,x);
					     y=end2.indexOf(delimeter);

						 if(y!=-1) {
						 	x=y;
							if(x!=0){
								fos.write(buffer,0,x-1);
							}
							break;
						 }
					}else if(x==delimeter.length()+3)	{
						 int y=0;
						 String end2=new String(buffer,0,x);
					     y=end2.indexOf(delimeter);

						 if(y!=-1) {
						 	x=y;
							if(x!=0)	{
								fos.write(buffer,0,x-2);
							}
							break;
						 }
					} else {
						if(x==1023)	{
							fos.write(buffer,0,x);
							x=0;
						} else if (ch=='\n') {
							 if (x>=2 && buffer[x-2]=='\r'&& buffer[x-1]=='\n'){
									fos.write(buffer,0,x-2);

									buffer[0] = '\r';
									buffer[1] = '\n';

									x=2;
							 } else {
									fos.write(buffer,0,x);
									x=0;
							 }
						}
					 }
				 }

				 fos.close();
				 filesize = size;
			}
			parameters.put(input_name, localname);
		}catch(Exception e){
			success = false;
			error_msg = "receiveFileData() " + e.getMessage();
			e.printStackTrace();
		}
	}

	public Hashtable getParameters() {
		return parameters;
	}

	public char getSeparator() {
		return separator;
	}

	public void setParameters(Hashtable parameters) {
		this.parameters = parameters;
	}

	public void setSeparator(char separator) {
		this.separator = separator;
	}

}
