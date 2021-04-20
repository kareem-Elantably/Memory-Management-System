/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.pkgfinal.project;

import java.util.*;
import java.io.*;
import javax.swing.*;



public class OSFinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       
        int holes=0;
       int ffholes=0;
       int bfholes=0;
       int wfholes=0;
        int nopar=1;
        int nopro=0;
      //  int any=1;
               
        
        
        System.out.println("enter the number of your partitions :");
        Scanner f=new Scanner(System.in);
         nopar=f.nextInt(); 
         int []part=new int[nopar];
        
        System.out.println("enter the number of your processes :");
         Scanner l=new Scanner(System.in);
         nopro=l.nextInt();
         int []process=new int[nopro];
        
         
         
         
        System.out.println("If you want to enter your data press 1");
        System.out.println("If you want to load your data from a text file press 2");
        Scanner c11=new Scanner(System.in);
        Scanner c22=new Scanner (System.in);
        File profile=new File("C:\\\\Users\\\\G3bour Store\\\\Desktop\\\\processes");
        File partfile=new File("C:\\\\Users\\\\G3bour Store\\\\Desktop\\\\partitions");
       Scanner scfpro=new Scanner(profile);
       Scanner scfpar=new Scanner(partfile); 
        
        

         int []nl=new int[nopar];
        for(int i=0;i<nl.length;i++)
            nl[i]=0;

        
        int []locate=new int[nopro];
        for(int i=0;i<locate.length;i++)
            locate[i]=-1;
        
        int []parted=new int[nopar];
        for(int i=0;i<parted.length;i++)
            parted[i]=-1;

          
          
        
        int c1=c11.nextInt();
        
        
        if(c1==1)
        {
        
        
         System.out.println("enter your partitions(in order) :");
         
        for(int i=0;i<nopar;i++)
        {
           
            Scanner pa=new Scanner(System.in);
            part[i]=pa.nextInt();
                   
        }
        System.out.println("enter your processes(in order) :");
        
        for(int i=0;i<nopro;i++)
        {
            Scanner pr=new Scanner(System.in);
            process[i]=pr.nextInt();
        
        }
        }
       
        else if(c1==2)
        {
              System.out.println("Your Partitions :");               
              for(int j=0;j<nopar;j++)
       {
          
           part[j]=scfpar.nextInt();
           System.out.println(part[j]);
       }
            
            System.out.println("Your processes :");
       for(int i=0;i<nopro;i++)
       {
          
        process[i]=scfpro.nextInt();
           System.out.println(process[i]);
       }
          
       
        
        
        }
        
        System.out.println("If you want to view first fit algorithim press 1");
        System.out.println("If you want to view best fit algorithim press 2");
        System.out.println("If you want to view worst fit algorithim press 3");
        System.out.println("If you want to view all algorithims and rank them acourding to their memory usage press 0");

        int c2=c22.nextInt();
       if(c2==1)
       {
       //first fit
            System.out.println("First Fit :");
    for(int i=0;i<nopro;i++)
    {
      
     for(int j=0;j<nopar;j++)
     {
         
     if(process[i]<part[j])
       {
           
         System.out.println(process[i]+" Put in "+part[j]); 
         
         
         part[j]-=process[i];
         parted[i]=part[j];
         locate[i]=j;
         break;
         
       }
     
     }
     if(locate[i]==-1)
     {
             System.out.println(process[i] +" Not allocated");
    nl[i]=process[i];
  
     }
    }
            
     System.out.println("The Holes :");
     for(int t=0;t<nopar;t++)
 {
     System.out.println(part[t] + " is a hole");
 holes+=part[t];
 }
         System.out.println("the total unused memory : "+holes);
         
         for(int h=0;h<nl.length;h++)
      {
         if(nl[h]!=0&&nl[h]<holes)
         {
               System.out.println("External Fragmentation in process : "+nl[h]);
                
               System.out.println("Solution of external fragmentation is compaction, paging and segmentation.");
         }
         else if(nl[h]!=0&&nl[h]>holes)
         {
         System.out.println("Internal Fragmentation in process : "+nl[h]);
                
                 System.out.println("The solution of internal fragmentation is best-fit block");
         
         }
      }
       }
    
       if(c2==2)
       {
       // Best Fit
           System.out.println("Best Fit :");
    for(int i=0;i<nopro;i++)
    {
    int min=-1;
    for(int j=0;j<nopar;j++)
    {
    if(part[j]>=process[i])
    {
        if(min==-1)
            min=j;
        else if(part[j]<part[min])
        min=j;
    }   
    }
    if(min!=-1)
    {
     System.out.println(process[i]+" Put in "+part[min]);
      for(int p=0;p<parted.length;p++)
         {
         if(part[min]==parted[p])
            {
             System.out.println("internal fragmentation in partition "+parted[p]);
         }}
    part[min]-=process[i];
     parted[i]=part[min];
    }
    else
    {
        System.out.println(process[i] +" Not allocated"); 
         nl[i]=process[i];
    }
    }
             //    System.out.println("The solution of internal fragmentation is best-fit block");
     System.out.println("The Holes :");
    for(int t=0;t<nopar;t++)
 {
     System.out.println(part[t] + " is a hole");
 holes+=part[t];
 }
          System.out.println("the total unused memory : "+holes);
          
       
          for(int h=0;h<nl.length;h++)
      {
         if(nl[h]!=0&&nl[h]<holes)
         {
               System.out.println("External Fragmentation in process : "+nl[h]);
                
               System.out.println("Solution of external fragmentation is compaction, paging and segmentation.");
         }
         else if(nl[h]!=0&&nl[h]>holes)
         {
         System.out.println("Internal Fragmentation in process : "+nl[h]);
                
                 System.out.println("The solution of internal fragmentation is best-fit block");
         
         }
      }  }
        
     if(c2==3)
     {
    // Worst Fit
         System.out.println("Worst Fit");
    for(int i=0;i<nopro;i++)
    {
    int max=-1;
    for(int j=0;j<nopar;j++)
    {
    if(part[j]>=process[i])
    {
        if(max==-1)
            max=j;
        else if(part[j]>part[max])
        max=j;
    }   
    }
    if(max!=-1)
    {
     System.out.println(process[i]+" Put in "+part[max]);
      for(int p=0;p<parted.length;p++)
         {
         if(part[max]==parted[p])
             {
             System.out.println("internal fragmentation in partition "+parted[p]);
            
         }}
    part[max]-=process[i];
     parted[i]=part[max];
    }
    
    else
    {
        System.out.println(process[i] +" Not allocated"); 
        nl[i]=process[i];
        
    }
     }
    // System.out.println("The solution of internal fragmentation is best-fit block");
    System.out.println("The Holes :");
    for(int t=0;t<nopar;t++)
 {
     System.out.println(part[t] + " is a hole");
 holes+=part[t];
 }
       System.out.println("the total unused memory : "+holes);
          
            for(int h=0;h<nl.length;h++)
      {
         if(nl[h]!=0&&nl[h]<holes)
         {
               System.out.println("External Fragmentation in process : "+nl[h]);
                
               System.out.println("Solution of external fragmentation is compaction, paging and segmentation.");
         }
         else if(nl[h]!=0&&nl[h]>holes)
         {
         System.out.println("Internal Fragmentation in process : "+nl[h]);
                
                 System.out.println("The solution of internal fragmentation is best-fit block");
         
         }
      } }
     
     
  if(c2==0)
  {
   System.out.println("First Fit :");
    for(int i=0;i<nopro;i++)
    {
      
     for(int j=0;j<nopar;j++)
     {
         
     if(process[i]<part[j])
       {
           
         System.out.println(process[i]+" Put in "+part[j]); 
         
         for(int p=0;p<parted.length;p++)
         {
         if(part[j]==parted[p])
         {
           //  System.out.println("internal fragmentation in partition "+parted[p]);
         }}
         
         
         parted[i]=part[j];
         part[j]-=process[i];
         locate[i]=j;
         break;
         
       }
     
     }
     if(locate[i]==-1)
     {
             System.out.println(process[i] +" Not allocated");
   nl[i]=process[i];
     }
    }
     System.out.println("The Holes :");
     for(int t=0;t<nopar;t++)
 {
     System.out.println(part[t] + " is a hole");
 ffholes+=part[t];
 }
         System.out.println("the total unused memory : "+ffholes);
         
       
             for(int h=0;h<nl.length;h++)
      {
         if(nl[h]!=0&&nl[h]<ffholes)
         {
               System.out.println("External Fragmentation in process : "+nl[h]);
                
               System.out.println("Solution of external fragmentation is compaction, paging and segmentation.");
         }
         else if(nl[h]!=0&&nl[h]>ffholes)
         {
         System.out.println("Internal Fragmentation in process : "+nl[h]);
                
                 System.out.println("The solution of internal fragmentation is best-fit block");
         
         }
      }   
  ////////////////////////////////////**************************************************//////////////////////////////////////     
  
  
        scfpro=new Scanner(profile);
        scfpar=new Scanner(partfile); 
  
        
  part=new int[nopar];
  process=new int[nopro];
  
   nl=new int[nopar];
        for(int i=0;i<nl.length;i++)
            nl[i]=0;
  
   locate=new int[nopro];
        for(int i=0;i<locate.length;i++)
            locate[i]=-1;
        
        parted=new int[nopar];
        for(int i=0;i<parted.length;i++)
            parted[i]=-1;

       
               System.out.println("Your Partitions :");               
              for(int j=0;j<nopar;j++)
       {
          
           part[j]=scfpar.nextInt();
           System.out.println(part[j]);
       }
              
               System.out.println("Your processes :");
       for(int i=0;i<nopro;i++)
       {
          
        process[i]=scfpro.nextInt();
           System.out.println(process[i]);
       }
  /////////////////////////////***************BEST FIT********************////////////////////////////////
    System.out.println("Best Fit :");
    for(int i=0;i<nopro;i++)
    {
    int min=-1;
    for(int j=0;j<nopar;j++)
    {
    if(part[j]>=process[i])
    {
        if(min==-1)
            min=j;
        else if(part[j]<part[min])
        min=j;
    }   
    }
    if(min!=-1)
    {
     System.out.println(process[i]+" Put in "+part[min]);
      
    part[min]-=process[i];
    }
    else
    {
        System.out.println(process[i] +" Not allocated"); 
         nl[i]=process[i];
    }
    }
           //      System.out.println("The solution of internal fragmentation is best-fit block");
     System.out.println("The Holes :");
    for(int t=0;t<nopar;t++)
 {
     System.out.println(part[t] + " is a hole");
 bfholes+=part[t];
 }
          System.out.println("the total unused memory : "+bfholes);
          
          for(int h=0;h<nl.length;h++)
      {
         if(nl[h]!=0&&nl[h]<bfholes)
         {
               System.out.println("External Fragmentation in process : "+nl[h]);
                
               System.out.println("Solution of external fragmentation is compaction, paging and segmentation.");
         }
         else if(nl[h]!=0&&nl[h]>bfholes)
         {
         System.out.println("Internal Fragmentation in process : "+nl[h]);
                
                 System.out.println("The solution of internal fragmentation is best-fit block");
         
         }
      }
  ////////////////////////////////////**************************************************//////////////////////////////////////     
  
  
        scfpro=new Scanner(profile);
        scfpar=new Scanner(partfile); 
  
  part=new int[nopar];
  process=new int[nopro];
  
      nl=new int[nopar];
        for(int i=0;i<nl.length;i++)
            nl[i]=0;
  
   locate=new int[nopro];
        for(int i=0;i<locate.length;i++)
            locate[i]=-1;
        
        parted=new int[nopar];
        for(int i=0;i<parted.length;i++)
            parted[i]=-1;

        
               System.out.println("Your Partitions :");               
              for(int j=0;j<nopar;j++)
       {
          
           part[j]=scfpar.nextInt();
           System.out.println(part[j]);
       }
              
               System.out.println("Your processes :");
       for(int i=0;i<nopro;i++)
       {
          
        process[i]=scfpro.nextInt();
           System.out.println(process[i]);
       }
  /////////////////////////////***************WORST FIT********************////////////////////////////////
  
       System.out.println("Worst Fit");
    for(int i=0;i<nopro;i++)
    {
    int max=-1;
    for(int j=0;j<nopar;j++)
    {
    if(part[j]>=process[i])
    {
        if(max==-1)
            max=j;
        else if(part[j]>part[max])
        max=j;
    }   
    }
    if(max!=-1)
    {
     System.out.println(process[i]+" Put in "+part[max]);
      
    part[max]-=process[i];
   
    }
    
    else
    {
        System.out.println(process[i] +" Not allocated"); 
       nl[i]=process[i]; 
        
    }
     }
    System.out.println("The Holes :");
    for(int t=0;t<nopar;t++)
 {
     System.out.println(part[t] + " is a hole");
 wfholes+=part[t];
 }
       System.out.println("the total unused memory : "+wfholes);
          
         for(int h=0;h<nl.length;h++)
      {
         if(nl[h]!=0&&nl[h]<wfholes)
         {
               System.out.println("External Fragmentation in process : "+nl[h]);
                
               System.out.println("Solution of external fragmentation is compaction, paging and segmentation.");
         }
         else if(nl[h]!=0&&nl[h]>wfholes)
         {
         System.out.println("Internal Fragmentation in process : "+nl[h]);
                
                 System.out.println("The solution of internal fragmentation is best-fit block");
         
         }
      }
     

  }
  if(ffholes<bfholes&&bfholes<wfholes)
            System.out.println("first fit algorithm is the most efficient then best fit algorithm and worst fit algorithm because the remained unused memory in first fit is smaller than the rest");
  else if(bfholes<ffholes&&ffholes<=wfholes)
                  System.out.println("best fit algorithm is the most efficient then first fit algorithm and worst fit algorithm because the remained unused memory in best fit is smaller than the rest");
 else if(wfholes<ffholes&&ffholes<=bfholes)
                  System.out.println("worst fit algorithm is the most efficient then first fit algorithm and best fit algorithm because the remained unused memory in worst fit is smaller than the rest");

      
        System.out.println("Thank you");
      int g=0; 
    Scanner e=new Scanner(System.in);
    g=e.nextInt();
    }
     
     
    }
    

