
class FunctionExample2{  
    static int n1=0,n2=1,n3=0;    
    static void printFunction(int count){           
            n3 = n1 + n2;                         
            n1 = n2;                               
            n2 = n3;                               
            System.out.print(" "+n3);  
            printFunction(count-1);          
    }    
   
    public static void main(String args[]){    
     int count=10;                              
     System.out.print(n1+" "+n2);  
     printFunction(count-2);  
    }  
   }  