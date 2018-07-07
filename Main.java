import java.io.*;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Hello World");
        Employee e=new Employee();

        e.newEmployee(101,"naseer",50000);
        e.newEmployee(102,"chaitanya",50000);
        e.newEmployee(103,"triraj",60000);

    }
}

class Employee{
    private String PATH = System.getProperty("user.dir");
    public void newEmployee(int empid,String ename,int esal) {

        PrintWriter pw = null;
        try {
            // pw = new PrintWriter(new File(PATH+"/employee.csv"));
            String filepath=PATH+"/employee.csv";
            RandomAccessFile rmfile=null;
            rmfile = new RandomAccessFile(filepath,"rw");
            rmfile.seek(rmfile.length());
            System.out.println(rmfile.length());
            System.out.println(rmfile.getFilePointer());
        

            StringBuilder sb = new StringBuilder();

            sb.append(empid);
            sb.append(",");
            sb.append(ename);
            sb.append(",");
            sb.append(esal);
            sb.append('\n');
            rmfile.writeBytes(String.valueOf(sb));
            System.out.println(sb);

            System.out.println("Length of rm file : " + rmfile.length());
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        //pw.write(sb.toString());
        //pw.close();

    }
    public void displayEmployees(){

    }
    public void DelEmployee(int empid){

    }

}
