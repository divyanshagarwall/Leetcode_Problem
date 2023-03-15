import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
 int t=sc.nextInt();
 
 
 while(t>0){
     int s = sc.nextInt();
     int a[]=new int[s];
     int op = 0;
     int tp=0;
     
     for(int i=0;i<s;i++)
         a[i]=sc.nextInt();
         
     for (int i=s-1;i>=0;i--){
         if(tp%2==0){
             op += (a[i]*a[i]);
             tp++;
         }else{
             op -= (a[i]*a[i]);
             tp++;
         }
     }
     System.out.println(op);
     t--;
 }
	 }
}