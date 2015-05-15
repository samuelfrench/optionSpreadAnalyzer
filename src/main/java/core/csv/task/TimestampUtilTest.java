package core.csv.task;

public class TimestampUtilTest {
public static void main(String[] args){
	p(LoadAllDB.getTimestamp((long) 1429796069).getHour());
}
private static void p(int s){
	System.out.println(s);
}
}
