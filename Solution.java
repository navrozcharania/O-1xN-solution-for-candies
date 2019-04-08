import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        //Stack st=new Stack(n);
        int count=0,prev=0,current=0,prev_count=0,peak=0,descent=0;
        for(int i=0;i<n;i++)
            {
            prev=current;
            //System.out.print(prev_count+" count:"+count+" ");
            current = sc.nextInt();
            if(i==0)
                {
                //prev=current;
                prev_count=1;
                peak=prev_count;
                count=1;
                continue;
            }
            if(current>prev)
                {
                if(descent>0)
                    {
                    int temp=descent*(descent-1)/2;
                    count=count+temp;
                    if(descent+1>peak)
                        count=count+(descent+1-peak);
                }
                //prev=current;
                prev_count=prev_count+1;
                peak=prev_count;
                count=count+prev_count;
                descent=0;
                continue;
                
            }
            if(current==prev)
            {
                if(descent>0)
                    {
                    int temp=descent*(descent-1)/2;
                    count=count+temp;
                    if(descent+1>peak)
                        count=count+(descent+1-peak);
                }
                descent=0;
                
                count=count+1;
                prev_count=1;
                peak=prev_count;
                //prev=current;
                continue;
            }
            if(current<prev)
                {
                descent++;
                count=count+1;
                prev_count=1;
                //prev=current;
                continue;
                
            }
            
            
        }
        if(descent>0&&current<prev)
                    {
                    int temp=descent*(descent-1)/2;
                    count=count+temp;
                    if(descent+1>peak)
                        count=count+(descent+1-peak);
            
                }
        //System.out.println(prev_count);
        System.out.println(count);
    }
}

