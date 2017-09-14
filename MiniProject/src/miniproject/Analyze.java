/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author prafful
 */
public class Analyze {
      String userVector[] = new String[6];
      public Analyze(String userVector)
      {
         this.userVector = userVector.split(" "); 
      }
    public void Compvectors() throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(new File("/home/prafful/alcohol-detection/dump.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/prafful/alcohol-detection/vectordistance.txt")));
        String line = "";
        String temp[];
        while ((line = br.readLine()) != null) 
        {
            temp = line.split(" ");


            float dist = 0;
            int t1, t2, diff = 0;
            for (int i = 0; i < userVector.length; i++) 
            {
                t1 = Integer.parseInt(userVector[i].trim());
                t2 = Integer.parseInt(temp[i + 1].trim());
                diff = t1 - t2;
                diff = diff * diff;
                dist += diff;
            }
            float d = (float) Math.sqrt(dist);
            System.out.println(d);

            bw.write(dist + " " + temp[0] + "\n");
        }
        br.close();
        bw.close();
    }
     public String resultKNN(int k) throws FileNotFoundException, IOException 
    {
        String alcoholic[] = new String[k];
        float distance[] = new float[k];
        for (int i = 0; i < k; i++) 
        {
            distance[i] = 9999;
        }
        BufferedReader br = new BufferedReader(new FileReader(new File("/home/prafful/alcohol-detection/vectordistance.txt")));
        String line;
        String temp[];
        while ((line = br.readLine()) != null) 
        {
            temp = line.split(" ");
            float td = Float.parseFloat(temp[0]);
            int in = getMax(distance);
            if (td < distance[in]) 
            {
                distance[in] = td;
                alcoholic[in] = temp[1];
            }
        }
        br.close();
        for (int i = 0; i < distance.length; i++)
        {
            System.out.println(distance[i] + " " + alcoholic[i]);
        }
        return getResult(alcoholic);
    }
       public String getResult(String[] s) 
    {
        String result="";
        int count=0,max=0;
        Set st=new HashSet();
        for(int i=0;i<s.length;i++){
            st.add(s[i]);
         }
        
        Iterator itr=st.iterator();
        while(itr.hasNext()){
            String temp=itr.next().toString();
            count=0;
            for(int i=0;i<s.length;i++){
                if(temp.equals(s[i])){
                    count++;
                }
            }
            if(count>=max){
                max=count;
                result=temp;
            }
        }
        return result;
    }
       public int getMax(float arr[]) {
        float n = 0;
        int in = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > n) {
                n = arr[i];
                in = i;
            }
        }
        return in;
    }
}
