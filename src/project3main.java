import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class project3main {

	public static void main(String[] args)throws FileNotFoundException {
		
		
		Scanner reader = new Scanner(new File(args[0]));
		reader.useLocale(Locale.US);
		PrintStream writer = new PrintStream(new File(args[1]));
		Operations operations = new Operations();
		ArrayList<Integer>  path = new ArrayList<>();
		
		
		
		//reading phase
		
		int timeLimit =  reader.nextInt();
		reader.nextLine();
		int totalNumOfCities = reader.nextInt();
		reader.nextLine();
		String mecnunNode = reader.next();
		String leylaNode = reader.next();
		int firstGraphCities = getInt(leylaNode) ;
		int secGraphCities = totalNumOfCities-firstGraphCities+1;
		Graph firstGraph = new Graph(firstGraphCities);
		Graph secGraph = new Graph(secGraphCities);
		reader.nextLine();
		
		
		
		for(int i = 0; i<(firstGraphCities-1) ;i++) {
			Scanner lineScanner = new Scanner(reader.nextLine());
			String  city = lineScanner.next();
			if (!lineScanner.hasNext()) {
				firstGraph.addNoExit(i);
			}
			while(lineScanner.hasNext()) {
			
			firstGraph.addRoad(i, getInt(lineScanner.next())-1, lineScanner.nextInt());
			
			}
			
			
		}
		for(int i = 0; i<(secGraphCities) ;i++) {
			Scanner lineScanner = new Scanner(reader.nextLine());
			String  city = lineScanner.next();
			if (!lineScanner.hasNext()) {
				secGraph.addNoExit(i);
			}
			while(lineScanner.hasNext()) {
				String tmpString = lineScanner.next();
				if(tmpString.substring(0, 1).equals("d")) {
				secGraph.addUndirectedRoad(i, getInt(tmpString), lineScanner.nextInt());
				}else {
					lineScanner.nextInt();
				}
			}
		}
		firstGraph.addNoExit(firstGraphCities-1);
		path = operations.dijkstrasAlgo(firstGraph);
		
		
		//printing phase
		
		if (path.size() == 0) {
			writer.print("-1\n-1");
		}else {
			int elapsed =path.remove(path.size()-1);
			
			for(int i = path.size()-1 ; i>= 0; i--) {
				writer.print("c" + (path.get(i)+1));
				if (i !=0 ) {
					writer.print(" ");
				}
			}
			writer.print("\n");
		if( elapsed <= timeLimit) {
			if (operations.primsAlgo(secGraph) == -5) {
				writer.print("-2");
			}else {
				writer.print(2*operations.primsAlgo(secGraph));
			}
			
		}else {
		
			
			writer.print("-1");
		}
		
		}
	}

	
	public static int getInt(String s) {
		return Integer.parseInt(s.substring(1,s.length()));
	}

}
