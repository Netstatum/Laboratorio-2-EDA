package Interno;

class AVLAS{
	Snodo K1;
	Snodo K2;
	Snodo K3;
	
	private static Snodo RSI(Snodo foco){		
		if(foco.getSnodoIzq().getEquilibrio()==-2){
			K2.igualar(foco.getSnodoIzq());
			K1.igualar(foco.getSnodoIzq().getSnodoIzq());
			
			K2.setSnodoIzq(K1.getSnodoDer());
			K1.setSnodoDer(K2);
			
			//calcular equilibrio
			
			foco.setSnodoIzq(K1);

			return foco;
		}else{
			K2.igualar(foco);
			K1.igualar(foco.getSnodoIzq());
			
			K2.setSnodoIzq(K1.getSnodoDer());
			K1.setSnodoDer(K2);
			
			
			//calcular equilibrio
			
			return K1;
		}
	}
	
	private static Snodo RSD(Snodo foco){		
		if(foco.getSnodoDer().getEquilibrio()==2){
			K2.igualar(foco.getSnodoDer());
			K1.igualar(foco.getSnodoDer().getSnodoDer());
			
			K2.setSnodoDer(K1.getSnodoIzq());
			K1.setSnodoIzq(K2);
			
			//calcular equilibrio
			
			foco.setSnodoDer(K2);

			return foco;
		}else{
			K2.igualar(foco);
			K1.igualar(foco.getSnodoDer());
			
			K2.setSnodoDer(K1.getSnodoIzq());
			K1.setSnodoIzq(K2);
			
			//calcular equilibrio
			
			return K1;
		}
	}
	
	private static Snodo RDI(Snodo foco){
		if(foco.getSnodoIzq().getEquilibrio()==-2){
			K3.igualar(foco.getSnodoIzq().getSnodoIzq());
			
			K3.igualar(RSD(K3));
			K2.igualar(foco.getSnodoIzq());
			K2.setSnodoIzq(K3);
			foco.setSnodoIzq(K2);
			
			foco.igualar(RSI(foco));
		}else{
			K3.igualar(foco.getSnodoIzq());
			
			K3.igualar(RSD(K3));
			foco.setSnodoIzq(K3);
			
			foco.igualar(RSI(foco));
		}
		
		return foco;
	}
	
	private static Snodo RDD(Snodo foco){
		if(foco.getSnodoDer().getEquilibrio()==2){
			K3.igualar(foco.getSnodoDer().getSnodoDer());
			
			K3.igualar(RSI(K3));
			K2.igualar(foco.getSnodoDer());
			K2.setSnodoDer(K3);
			foco.setSnodoDer(K2);
			
			foco.igualar(RSD(foco));
		}else{
			K3.igualar(foco.getSnodoDer());
			
			K3.igualar(RSI(K3));
			foco.setSnodoDer(K3);
			
			foco.igualar(RSD(foco));
		}
		
		return foco;
	}
}