package pageObjects;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class CurrentTime {

	static int exphour ;
	static	int expmin ;
	static String expwaqt;
	
	static int endhrs=01 ;
	static  int endmin=00 ;
	static int Displayhour=01 ;
	static	int Displaymin=00;
	static String Displaywaqt="PM";
	
	static int i;
	public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        System.out.println( sdf.format(cal.getTime()) );
        
        String  currenttime= sdf.format(cal.getTime());
        
         exphour=Integer.parseInt(currenttime.substring(0, 2));
         expmin=Integer.parseInt(currenttime.substring(3, 5));
         expwaqt=currenttime.substring(6);
          i=(int)expmin/15 ;
        
if((exphour==Displayhour) && (i!=3 )){
	
	System.out.println("Enter here 1");
	
	for(int j=1;j<=i+1;j++){
		
		Displayhour=minuteCalculation();
		
		
		
	}
	
}
else if((exphour==Displayhour) && (i==3 )){
	System.out.println("Enter here 2");
	
	Displayhour=hourCalculation();

}
else if((exphour!=Displayhour) && (i!=3 )){
	System.out.println("Enter here 3");

	for(int j=1;j<exphour;j++){
	
		Displayhour=	hourCalculation();
	}

	for(int j=1;j<=i+1;j++){
		
	Displaymin=	minuteCalculation();

	}	
}

else if((exphour!=Displayhour) && (i==3 )){
	
	System.out.println("Enter here 4");
	
	for(int j=1;j<=exphour;j++){
		
		Displayhour=	hourCalculation();
	}
 
}        
        
System.out.println("Calculated time");
System.out.println(Displayhour+":"+Displaymin+":"+Displaywaqt);

//:::::::::::::::::::::::2nd time frame job

int set=(int)Displaymin/15 ;

if((endhrs==Displayhour) && (set!=3 )){

	System.out.println("Enter here 1");
	
	for(int j=1;j<=set+1;j++){
		
		endhrs=endMinuteCalculation();
	}

}

if((endhrs==Displayhour) && (set==3 )){
	
System.out.println("Enter here 2");
	
	endhrs=endHourCalculation();

	
	
}

if((endhrs!=Displayhour) && (set!=3 )){
	
	System.out.println("Enter here 3");

	for(int j=1;j<Displayhour;j++){
	
		endhrs=	endHourCalculation();
	}

	for(int j=1;j<=set+1;j++){
		
	endmin=	endMinuteCalculation();

	}	
	
	
}

if((endhrs!=Displayhour) && (set==3 )){
	
System.out.println("Enter here 4");
	
	for(int j=1;j<=Displayhour;j++){
		
		endhrs=	endHourCalculation();
	}
 
	
}


System.out.println("End time :"+endhrs+":"+endmin+":");
	}

public static int hourCalculation(){
	
	

   Displayhour++ ;
   
return Displayhour;

}	

public static int minuteCalculation(){

	Displaymin=Displaymin+15 ;
	
	return Displaymin;
}	
	
public static int endHourCalculation(){
	   endhrs++ ;
	   
	//   System.out.println(Displayhour);
	return endhrs;
	}	

	public static int endMinuteCalculation(){

		endmin=endmin+15 ;
		
//		System.out.println(Displaymin);
		return endmin;
	}	

}
