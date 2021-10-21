
public class WierszTrojkataPascala {
	public final long[] tab;
	
	public long  sil(long n) {
		if (n==0 || n==1) return 1;
		else return n*sil(n-1);
		
	}
		
	
	
	public long wspolczynnik(int m) {
		return tab[m];}
	
	
	
	
	WierszTrojkataPascala(int n){
		
		tab = new long[n+1];
		for(int e=0; e<tab.length; e++) {
			
			tab[e]=sil(n)/(sil(n-e)*sil(e));
		}
			
		}
		



}
	
	


