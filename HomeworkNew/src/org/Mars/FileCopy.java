package org.Mars;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;

public class FileCopy {
	 BufferedReader reader;
	 static String sourceName;
	 static String desName;
    private FileCopy(){
    	File source;
    	File destination;
    	boolean isOK=false;
    	try{
    		do{
    	       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    	       System.out.println("請輸入來源檔案(想要複製的檔案或資料夾)");
    	       sourceName=reader.readLine();
    	       source=new File(sourceName);
    	       if(!source.exists()){
    	    	  System.out.println("來源檔不在，請從新輸入檔名");
    	    	  isOK=true;
    	       }
    	       else{
    	    	   isOK=false;
    	    	   break;
    	       }
    	    }while(isOK);
    		reader=new BufferedReader(new InputStreamReader(System.in));
    		boolean check=true;
    		while(check){
    	            System.out.println("請輸入目標檔(要複製過去的資料夾)");
    	            desName=reader.readLine();
    	            String[] des=desName.split("/");
    	            if(!des[0].equals("C:")&&!des[0].equals("D:")&&!des[0].equals("Q:")){
    	     	        System.out.println("你所選擇的硬碟槽不存在，請從新輸入");
    	            }
    	            else{
    	            	source=new File(sourceName);
    	                destination=new File(desName);
    	            	copy(source,destination);
    	            	check=false;
    	            	break;
    	            }
    		}//end while loop
    		//copy(source,destination);
    	}
    	catch(IOException ie){
    		ie.toString();
    	}
   
    }//close constructor
	public static void main(String[] args) {
	  new FileCopy();
	}//close method main()
    
	public void copy(File source,File destination){
		source=new File(sourceName);
		destination=new File(desName);
		if(source.isFile()){
			if(destination.isDirectory()&&!destination.exists()){
				destination.mkdirs();
			}
		    try{
		    	File des_file=new File(destination,source.getAbsolutePath());
		    	System.out.println(des_file.getPath());
		    	System.out.println("開始執行複製");
		    	//FileOutputStream不知為何會拋出例外，導致下面的複製程序完全沒有執行，明明確認過檔案是存在的
                FileOutputStream fout=new FileOutputStream(des_file);
                System.out.println("建立FileOutputStream");
                System.out.println("Before InputStream");
                FileInputStream fin=new FileInputStream(source);
		        System.out.println("建立FileInputStream");
		        byte[] b=new byte[1024];
				int c;
			    System.out.println("start");
				while((c=fin.read(b))!=-1){
					fout.write(b);
				}//end while loop
				fout.flush();
				fout.close();
				fin.close();
				System.out.println(destination+source.getAbsolutePath() +".... ok"  );
		    }
		    catch(FileNotFoundException fe){
		    	System.out.println("FileNotFound xx");
		    	fe.toString();
		    }
		    catch(IOException ie){
		    	System.out.println("IOException xxx");
		    	ie.toString();
		    }
		    catch(SecurityException se){
		    	System.out.println("SecurityException xxxx");
		    }
		}
		else{
			for( File f:source.listFiles()){
				if(f.isDirectory()){
					//找下面一層
					if(!new File(destination,f.getPath()).exists()){
						new File(destination,f.getPath()).mkdirs();
						System.out.println(destination+f.getAbsolutePath() +".... ok"  );
					}
					copy(f,destination);
				}
				else{
					//執行檔案複製
					File des_file=new File(destination,f.getPath());
					System.out.println(des_file.getPath());
					try{
						OutputStream out=new FileOutputStream(des_file);
						InputStream in=new FileInputStream(f);
						byte[] b=new byte[1024];
						int c;
						while((c=in.read(b))!=-1){
							out.write(b);
						}//end while loop
						System.out.println(destination+f.getAbsolutePath() +".... ok"  );
						out.flush();
						out.close();
						in.close();
					}
					catch(Exception e){
						e.toString();
					}
				}
			}//end for loop
		}
	}//close method copy
}//close class
