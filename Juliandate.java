
public class Juliandate {
	private int day;
	private int month;
	private int year;
	private int hour;
	private int miniute;
	private int seconds;
	public Juliandate(int y,int m,int d,int hour,int miniute,int seconds){
		day = d;    //1~28/30/31
		month = m;   //1~12
		year = y;   //
		this.hour = hour;   //  1~24
		this.miniute = miniute;   // 0~60
		this.seconds = seconds;		//0~60
	}
	public Juliandate(){
		
	}
	public Juliandate(int y,int m,int d){
		day = d;
		month = m;
		year = y;
		hour = 0;
		miniute = 0;
		seconds= 0;
	}
	public int daysofmonth(int month){
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			return 31;
		}
		else if(month==2){
			if(isLeapyear(year)){
				return 29;
			}
			return 28;
		}
		else return 30;
	}
	public Juliandate add(double d){
		int days = (int)d;
//		System.out.println(days);
		double extra = d-days;
//		System.out.println(extra);
//		String str = Double.toString(d);
//		int days = Integer.parseInt(str.substring(0,str.indexOf('.')));
//		double extra = Double.parseDouble((str.substring(str.indexOf('.'))));
//		System.out.print(days);
		Juliandate a1 = new Juliandate();
		a1.day = day;
		a1.month = month;
		a1.year = year;
		a1.hour = hour;
		a1.miniute = miniute;
		a1.seconds = seconds;
		
		int h = (int)(extra*24);
//		System.out.println(h);
		int min = (int)((extra*24-h)*60);
//		System.out.println(min);
		int sec = (int)(((extra*24-h)*60-min)*60);
//		System.out.println(sec);
		a1.seconds+=sec;
		a1.miniute+=min;
		a1.hour+=h;
		while(a1.seconds>=60){
			a1.miniute++;
			a1.seconds-=60;
		}
		while(a1.miniute>=60){
			a1.hour++;
			a1.miniute-=60;
		}
		while(a1.hour>=24){
			days++;
			a1.hour-=24;
		}
		a1.day+=days;
		while(a1.day>daysofmonth(a1.month)){
			if(is31daysmonth(a1.month)){
				a1.day-=31;
				a1.month++;
			}
			else {
				if(a1.month==2){
					if(isLeapyear(a1.year)){
						a1.day-=29;
						a1.month++;
					}else{
						a1.day-=28;
						a1.month++;
					}
				}
				else {
					a1.day-=30;
					a1.month++;
				}
			}
		}
		while(a1.month>12){
			a1.month-=12;
			a1.year++;
		}
		return new Juliandate(a1.year,a1.month,a1.day,a1.hour,a1.miniute,a1.seconds);
	}
	public void setTime(int h,int m,int sec){
		this.hour = h;
		this.miniute = m;
		this.seconds = sec;
	}
	public int sub(Juliandate a){
		if(day==a.day&&month==a.month&&year==a.year)
			return 0;
		int days=0;
		int y1;
		y1 = year;
		int day1=0,day2=0;
		for(int i=1;i<month;i++){
			if(is31daysmonth(i)){
				day1+=31;
			}
			else day1+=30;
		}
		day1+=day;
		for(int i=1;i<a.month;i++){
			if(is31daysmonth(i)){
				day2+=31;
			}
			else day2+=30;
		}
		day2+=a.day;
		if(day1>day2){
			days+=day1-day2;
		}
		else{
			if(isLeapyear(year-1)){
				days+=day1+366-day2;
				y1--;
			}
			else {
				days+=day1+365-day2;
				y1--;}
		}
		for(int i=a.year;i<y1;i++){
			if(isLeapyear(i)){
				days+=366;
			}
			else days+=365;
		}

		
		return days;


	}
	public String toString(){
		return "date is"+" "+this.year+" "+this.month+" "+this.day+" "+this.hour+":"+this.miniute+":"+this.seconds;

	}
	public boolean isLeapyear(int year){
		return (year%4==0)&&(year%100!=0)||(year%400==0);
	}
	public boolean is31daysmonth(int month){
		return (month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12);
	}

	public static void main(String[] args){
		Juliandate a = new Juliandate(2017,2,27);
		Juliandate j1 = new Juliandate(2016,2,29,11,10,0);
		System.out.println(j1);
		j1 = j1.add(2.5);
		System.out.println(j1);
		
		j1.setTime(22, 54, 40);
		System.out.println(j1);
		for(int i =0;i<3;i++){
			 a = a.add(1);
			 System.out.println(a);
		}
		


	}
}
