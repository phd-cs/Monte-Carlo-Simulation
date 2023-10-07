public class simu {
	
	double x = Math.random();
	private double Pab = 0.32;
	private double Pba = 0.32;

	private double Pac = 0.32;
	private double Pca = 0.32;

	private double Pbd = 1;
	private double Pdb = 1;

	private double Pbe = 0.71;
	private double Peb = 0.71;

	private double Pce = 0.34;
	private double Pec = 0.34;

	private double Pcg = 0.53;
	private double Pgc = 0.53;

	private double Pdf = 0.33;
	private double Pfd = 0.33;

	private double Peg = 0.34;
	private double Pge = 0.34;

	private double Pfg = 0.43;
	private double Pgf = 0.43;

	private boolean a = Pab <= x;
	private boolean b = a;

	private boolean c = Pac <= x;
	private boolean cc = c;
	
	private boolean d = Pbd <= x;
	private boolean dd = d;
	
	private boolean e = Pbe <= x;
	private boolean ee = e;
	
	private boolean cccc = Pce <= x;
	private boolean ccccc = cccc;
	
	private boolean g = Pcg <= x;
	private boolean gg = g;
	
	private boolean f = Pdf <= x ;
	private boolean ff = f;
	
	private boolean q = Peg <= x;
	private boolean qq = q;
	
	private boolean ft = Pfg <= x;
	private boolean ftt = ft;
	
	private int reps = 1000000;
	
	public simu(double Pab, double Pac, double Pbd, double Pbe, double Pce, double Pcg, double Pdf, double Peg, double Pfg, int reps) {
		this.Pab = Pab;
		this.Pba = Pab;
		this.Pac = Pac;
		this.Pca = Pac;
		this.Pbd = Pbd;
		this.Pdb = Pbd;
		this.Pbe = Pbe;
		this.Peb = Pbe;
		this.Pce = Pce;
		this.Pec = Pce;
		this.Pcg = Pcg;
		this.Pgc = Pcg;
		this.Pdf = Pdf;
		this.Pfd = Pdf;
		this.Peg = Peg;
		this.Pge = Peg;
		this.Pfg = Pfg;
		this.Pgf = Pfg;
		this.reps = reps;
	}

    private simu(){

    }
	
	public double formel(){
		double result = ((1-Pac)*((1-Pcg) + Pcg*((1-Pce)*((1-Peg) + Peg*(1-Pbe)*(1-Pbd)*(1-Pdf)*(1-Pfg))))) + (1-((1-Pac)*((1-Pcg) + Pcg*((1-Pce)*((1-Peg) + Peg*(1-Pbe)*(1-Pbd)*(1-Pdf)*(1-Pfg))))))*((1-Pab)*((1-Pbd)*(1-Pdf)*(1-Pfg) + (1 - (1-Pbd)*(1-Pdf)*(1-Pfg))*((1-Pbe)*((1-Peg) + Peg*(1-Pce)*(1-Pcg)))));			
		return result;
	}
	
	public int simulation() {
		if(a) {
			if(b && f && ft) {
				return 1;
			}
			if(e){
				if(q) {
					return 1;
				}
				if(cccc && g) {
					return 1;
				}
			}
			d = Pbd <= Math.random();
			b = a;
			e = Pbe <= Math.random();
			ee = e;
			cccc = Pce <= Math.random();
			ccccc = cccc;
			g = Pcg <= Math.random();
			gg = g;
			f = Pdf <= Math.random();
			ff = f;
			q = Peg <= Math.random();
			qq = q;
			ft = Pfg <= Math.random();
			ftt = ft;
                      }
		if(c) {
			if(g) {
				return 1;
			}
			if(cccc) {
				if(q) {
					return 1;
				}
				if(e && d && f && ft) {
					return 1;
				}
                            }
                        }
	return 0;
	}
	
	public static void main(String[] args) {
		int sum = 0;
		simu sim = new simu();
		int re = sim.reps;
                
		for(int i = 0; i < re; i++) {
			sim = new simu();
			sum = sum + sim.simulation();
		}
                
		double q = (double) sum / (double) re;
		double formel = sim.formel();
		
                System.out.println("Formula: " + formel);
		System.out.println("Simulation: " + q);
	}

}
