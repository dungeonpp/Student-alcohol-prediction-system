/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import org.slf4j.impl.StaticLoggerBinder;

/**
 *
 * @author prafful
 */
public class DumpGenerate {
    Scanner sc = new Scanner(System.in);
     static int sel = 0;
    static Cluster cluster;
    static Session session;
    static ResultSet results;
    static Row rows;
    static double sr_no,age,pstatus,famrel,freetime,goout,health,result;
 
    static Set s,a,ps,fr,ft,go,h,res;
    static String userVector;
    
    public DumpGenerate(String userVector) {
        this.userVector=userVector;
    }
   public static void main(String[] args) throws IOException 
    {
        s = new HashSet();
        a = new HashSet();
        ps= new HashSet();
        fr = new HashSet();
        ft = new HashSet();
        go = new HashSet();
       h= new HashSet();
       res=new HashSet();

        Scanner sc = new Scanner(System.in);
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect();
        session.execute("USE Mykeyspace");
        ResultSet result = session.execute("select * from student");
        double temp ;
        File file = new File("/home/prafful/alcohol-detection/dump.txt");
        FileWriter writer = new FileWriter(file);
        BufferedWriter br = new BufferedWriter(writer);
 
        for (Row rows : result)
        {
            
            br.write(rows.getInt("result") + " " + rows.getInt("age") + " " +rows.getInt("pstatus") + " "
                    + rows.getInt("famrel") + " " + rows.getInt("goout") + " "+rows.getInt("freetime")+" "
                    + rows.getInt("health") + "\n");


            System.out.println(rows.getInt("result") + " " + rows.getInt("age") + " " +rows.getInt("pstatus") + " "
                    + rows.getInt("famrel") + " " + rows.getInt("goout") + " "+rows.getInt("freetime")+" "
                    + rows.getInt("health") + "\n");
            /*temp = row.getDouble("sr_no");
            if (temp != 0) 
            {
               s.add(temp);
            } 
            else 
            {
                s.add("null");
            }

            temp = row.getDouble("age");
            if (temp != 0) 
            {
                a.add(temp);
            } 
            else 
            {
                a.add("null");
            }

            temp = row.getDouble("famrel");
            if (temp != 0)
            {
                fr.add(temp);
            }
            else 
            {
                fr.add("null");
            }

            temp = row.getDouble("result");
            res.add(temp);
             temp = row.getDouble("pstatus");
            ps.add(temp);
           
            temp = row.getDouble("freetime");
            if (temp != 0) 
            {
                ft.add(temp);
            } 
            else 
            {
                ft.add("null");
            }

            temp = row.getDouble("goout");
            if (temp != 0)
            {
                go.add(temp);
            } 
            else 
            {
                go.add("null");
            }
            
            temp = row.getDouble("health");
            if (temp != 0)
            {
               h.add(temp);
            } 
            else
            {
                h.add("null");
            }*/
        
        }
           br.close();
         /*File file = new File("/home/aish/Divya/dump.txt");
        FileWriter writer = new FileWriter(file);
        BufferedWriter br = new BufferedWriter(writer);
        ResultSet rr = session.execute("select * from student");*/
        /*for (Row row : rr)
        {
         
            br.write(row.getDouble("result") + " " + row.getDouble("age") + " " +row.getDouble("pstatus") + " "
                    + row.getDouble("famrel") + " " + row.getDouble("freetime") + " "+row.getDouble("health")+" "
                    + row.getDouble("goout") + "\n");


            System.out.println(row.getDouble("result") + " " + row.getDouble("age") + " " +row.getDouble("pstatus") + " "
                    + row.getDouble("famrel") + " " + row.getDouble("freetime") + " "+row.getDouble("health")+" "
                    + row.getDouble("goout") + "\n");
        }
        br.close();*/
    }
      /*public static int getIndex(Set s, double str) {
        Iterator<Double> itr = s.iterator();
        int i = 0;
        while (itr.hasNext())
        {
            double temp = itr.next();
            if (str==temp) 
            {
                return i;
            }
          
            i++;
        }
        return 0;
    }*/
      

}

