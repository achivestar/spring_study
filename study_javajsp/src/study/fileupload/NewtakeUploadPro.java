package study.fileupload;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Hashtable;

public class NewtakeUploadPro
{
	private InputStream data;
	public String path = "";
	public String file_name = null;
	public String file_value = null;
	public boolean overlap = false;
	private Handler  handler = null;
	private Comp comp = null;
	public Hashtable fileChange;
	public Hashtable pathChange;
	private Hashtable parameter;
	private Hashtable filename;
	private Hashtable filesize;

	public NewtakeUploadPro(InputStream _data)
	{

		data = _data;
		fileChange = new Hashtable();
		pathChange = new Hashtable();
	}

	public void setPath(String _path)
	{
		path = _path;
	}

	public void setOverlap(boolean _overlap)
	{
		overlap = _overlap;
	}

	public void filenameChange(String _filevalue ,String _filename)
	{

		 fileChange.put(_filevalue,_filename);
	}

	public void pathChange(String _filevalue ,String path)
	{
		 pathChange.put(_filevalue,path);
	}

	public String getParameter(String name)
	{
		return (String)parameter.get(name);
	}

	public String getFilename(String name)
	{
		return (String)filename.get(name);
	}

	public String getFilesize(String name)
	{
		return (String)filesize.get(name);
	}

	public String getError()
	{
		if(comp != null)
			return	comp.error;
		else
			return "";
	}

	public boolean upload_ok()
	{
		if(comp != null)
			return comp.upok;
		else
			return false;
	}

	public void start()
	{
		comp = new Comp();
		handler = new Handler(data, this, comp);
		parameter = handler.getParameter();
		filename = handler.getFilename();
		filesize = handler.getFilesize();
	}

	 // 2005.12.12 박경완 추가 (업로드된 파일을 move)
	 public String filemove(String _filename, String filepath)
	 {

		 String savepath = this.path;
		 String ext = "";
		 String fname = (String)filename.get(_filename);
		 if (!comp.upok || fname == null ) return null;
		 else ext = fname.substring(fname.lastIndexOf("."));

		 if ( fileChange.get(_filename) != null ) fname = (String)fileChange.get(_filename) + ext;
		 if ( pathChange.get(_filename) != null ) savepath = (String)pathChange.get(_filename);
		 try
		 {
			 File f1 = new File(savepath, fname);

			 if ( !f1.exists() ) throw new Exception(" file not found! ");
			 File p1 = new File(filepath);
			 File dest;
			 if ( !p1.isDirectory() ) {
				 if ( !p1.mkdirs() ) throw new Exception(" target directory make failed! ");
			 }

			 dest = new File(filepath,fname);
			 if ( dest.exists() ) throw new Exception(" already file exist! ");

			 f1.renameTo(dest);

			 pathChange.put(_filename,savepath);

			 return filepath;
		 }catch(Exception e)
		 {
			 comp.error = "filemove:"+ e.getMessage();
			 return null;
		 }
	 }

}


class Handler
{

 	private String end;
 	public String cont;
	public DataInputStream data;
	private String path;
	private Hashtable parameter;
	private Hashtable filename;
	private Hashtable filesize;
	private Hashtable fileChange;
	private Hashtable pathChange;
	private Comp comp;
	private NewtakeUploadPro uploadPro;


	public Handler(InputStream _data, NewtakeUploadPro _uploadPro, Comp _comp)
 	{
 		uploadPro = _uploadPro;
 		comp = _comp;
 		try{
 		fileChange = uploadPro.fileChange;
 		pathChange = uploadPro.pathChange;
 		path = uploadPro.path;
		parameter = new Hashtable();
 		filename = new Hashtable();
 		filesize= new Hashtable();
		data = new DataInputStream(_data);
		comp.end = data.readLine();
		this.end = comp.end;
 		data=new DataInputStream(_data);
 		start();

		}catch(Exception e)
		{
			comp.error = "handler:" +e.getMessage();
			comp.upok = false;
		}
 	}




	public void start()
	{
		try
		{

		  while((cont=data.readLine())!=null)
		 {

		 	synchronized(cont)
		 	{

		 	if(cont.indexOf(comp.DIVISION_WORD)!=-1)
		 	{
		 		if(cont.indexOf(comp.FILE_WORD)!=-1)
		 		{
		 			readData();

		 		}
		 		else getText();
		 		}
		 	}
		 }
		}catch(Exception e)
		{
			comp.error = "start:" + e.getMessage();
			comp.upok = false;
		}




	}


	 void getText()
	{
		try
		{
		 	int s_chk=cont.lastIndexOf("=")+2;
     	 	int e_chk=cont.lastIndexOf("\"");
		 	int line = 0;
		 	String text_value ="";
   	 	 	String text_name ="";
   	 	 	text_name=cont.substring(s_chk,e_chk);

		 	data.readLine();

		 	while(true)
		 	{
		 		  String temp=data.readLine();
		 	     if(temp==null)break;
         	     temp=new String(temp.getBytes("ISO-8859-1"),"Euc-kr");
         	     if(temp.indexOf(end)!=-1&&!temp.equals("\n"))break;
		 		 line ++;

				if(line==1) text_value+=temp;
				else text_value+="\n"+temp;
         	  }

		 	parameter.put(text_name,text_value);
		 }catch(Exception e)
		 {
		 	comp.error = "getText:"+e.getMessage();
		 	comp.upok = false;
		}

	}

		void readData()
	{
		try{
			 int s_chk= cont.lastIndexOf("form-data")+17;
			 int e_chk= cont.lastIndexOf("\";");
			 String text_name= cont.substring(s_chk,e_chk);

			 String file_name=null;

			 s_chk= cont.lastIndexOf("\\")+1;
			 e_chk= cont.lastIndexOf("\"");
			 	if(s_chk<0)s_chk=0;
				if(e_chk<0)e_chk=0;
			 	if (s_chk!=0)
			 	{
					file_name= cont.substring(s_chk,e_chk);
			 	}
			 	else
			 	{
			 	file_name="";
			 	}



			if(file_name.length()<50&&file_name.indexOf(".")!=-1){
			file_name=new String(file_name.getBytes("ISO-8859-1"),"Euc-kr");

		     String changefile = (String)fileChange.get(text_name);
			 String changepath = (String)pathChange.get(text_name);

			if(changefile!=null)file_name = changefile+file_name.substring(file_name.lastIndexOf("."));
			if(changepath!=null)path = changepath;

			if(uploadPro.overlap)file_name = filenamechk(path,file_name);

				 data.readLine();
				 data.readLine();

			FileOutputStream uploader=new FileOutputStream(path+file_name);

			byte[] buffer=new byte[1024];
			byte ch;
			boolean first = true;

			int x=0;
			int size=0;

			while(true)
			{
			size++;

				buffer[x++]=ch= data.readByte();
				if(x==end.length()+1)
				{
					 int y=0;
					 String end2=new String(buffer,0,x);
				     y=end2.indexOf(end);

					 if(y!=-1)
					 {
					 	x=y;
						if(x!=0)	{
							uploader.write(buffer,0,x-1);
						}
							break;
					 }
				}
				else if(x==end.length()+3)
				{
					 int y=0;
					 String end2=new String(buffer,0,x);
				     y=end2.indexOf(end);

					 if(y!=-1)
					 {
					 	x=y;
						if(x!=0)	{
							uploader.write(buffer,0,x-2);
						}
							break;
					 }
				}
				else
				{
					if(x==1023)
					{
						uploader.write(buffer,0,x);
						x=0;
					 }
					 else if (ch=='\n')
					 {

							if (x>=2 && buffer[x-2]=='\r'&& buffer[x-1]=='\n')
							{
								uploader.write(buffer,0,x-2);

								buffer[0] = '\r';
								buffer[1] = '\n';

								x=2;

							}
							else
							{
								uploader.write(buffer,0,x);
								x=0;
							}
					}
				 }
			 }

			 uploader.close();
			 String file_size=Integer.toString(size);
			 filename.put(text_name,file_name);
			 filesize.put(text_name,file_size);
			path = uploadPro.path;

			}

		}catch(Exception e)
		{
			e.printStackTrace();

			if(e.getMessage()!=null)
			{
			comp.error = "readData:"+  e.getMessage();
			comp.upok = false;
			}
		}

	}
	 public String filenamechk(String dir,String filename)
	 {
	   try
	   {
	       File f1=new File(dir,filename);
	       String temp=filename;
			for(int i=1;f1.exists();i++)
			{
				int st=temp.indexOf(".");
				String temp1=temp.substring(0,st);
				String temp2=temp.substring(st);
				String pk=Integer.toString(i);
				String ftemp="["+pk+"]";
				filename=temp1+ftemp+temp2;
				f1=new File(dir,filename);
			}

				return filename;
		}catch(Exception e)
		{

			comp.error = "filenamechk:"+ e.getMessage();
			comp.upok = false;
			return null;
		}

	 }

	public void close()
	{

	}

	public  Hashtable getParameter()
	{
		return parameter;
	}
	public Hashtable getFilename()
	{
		return filename;
	}
	public Hashtable getFilesize()
	{
		return filesize;
	}



}


class  Comp
{

	final  String DIVISION_WORD = "Content-Disposition:";
	final  String FILE_WORD = "filename=";
	public  String end = "";
	public  String error = "";
	public  boolean upok =true;
}




