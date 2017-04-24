import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Stock {
	private HashMap<String,Double> stocks = new HashMap<String,Double>();
	private String path;
	public Stock(String url) throws Exception{
		path = url;
		add(path);
	}
	public void add(String path) throws Exception{
		URL url = new URL(path);
		URLConnection http = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
		String line ;
		String enterprise;
		double stock;
		while((line = br.readLine())!=null){
			String[] temp = line.split(",");
			enterprise = temp[0].substring(1, temp[0].length()-1);
			stock = Double.parseDouble(temp[1]);
			stocks.put(enterprise, stock);
		}
	}
	public Double search(String key){
		return stocks.get(key);
	}
	public void display(){
		System.out.println("Enterprise"+'\t'+"Stocks");
		for(String key:stocks.keySet()){
			System.out.println(key+'\t'+'\t'+stocks.get(key));
		}
	}
	public static void main(String[] args) throws Exception{

		String path = " http://download.finance.yahoo.com/d/quotes.csv?s=MSFT,IBM,AAPL,GOOG,YHOO&f=sl1d1t1c1ohgv&e=.csv";
		Stock s = new Stock(path);
		s.display();

	}

}

