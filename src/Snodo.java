import java.util.Vector;
/** @class Snodo : 
	Esta Clase guarda todos los compuestos que pueden provocar un sintoma especifico asociado al Snodo.
	Los siguientes parametros representan los atributos de la clase:
	@param equilibrio : valor del equilibrio para arboles AVL
	@param sintoma : Guarda el nombre del sintoma que representa al Snodo
	@param izq : Hijo izquierdo de Snodo
	@param der : Hijo derecho de Snodo
	@param nombre_compuestos : Lista de nombres de los compuestos que pueden probocar el sintoma que representa al Snodo
*/
public class Snodo{
	private int equilibrio;
    private String sintoma;
    private Snodo izq;
	private Snodo der;
    private Vector<String> nombre_compuestos;
    
	/**Inicializa un nodo con valores nulos*/
    public Snodo() {
        this.sintoma=null;
		this.nombre_compuestos=new Vector();;
		
        this.izq=null;
        this.der=null;
		
		this.equilibrio=0;
    }
	
	/**Inicializa el Snodo con el nombre del sintoma
	   @param sintoma : nombre del sintoma
	*/
    public Snodo(String sintoma){
        this.sintoma=sintoma;
		this.nombre_compuestos = new Vector();;
		
        this.izq=null;
        this.der=null;
		
		this.equilibrio=0;
    }
	
	/**Inicializa el Snodo con el nombre de los compuestos asociados a un sintoma desconocido
	   @param nombre_compuestos : nombre de los compuestos que pueden provocar ese sintoma
	*/
    public Snodo(Vector<String> nombre_compuestos){
        this.sintoma=null;
		this.nombre_compuestos = nombre_compuestos;
		
        this.izq=null;
        this.der=null;
		
		this.equilibrio=0;
    }
    
	/**Inicializa el Snodo con el nombre del sintoma y los compuestos asociados
	   @param sintoma : nombre del sintoma
	   @param nombre_compuestos : nombre de los compuestos que pueden provocar ese sintoma
	*/
    public Snodo(String sintoma, Vector<String> nombre_compuestos){
        this.sintoma=sintoma;
		this.nombre_compuestos = nombre_compuestos;
		
        this.izq=null;
        this.der=null;
		
		this.equilibrio=0;
    }
	
	/** Reemplaza todo los valores del nodo por uno nuevo
		SOLO USAR SI AMBOS SNODOS SON IGUALES
	*/
	public void reemplazar(Snodo snodo){
		this.setSintoma(snodo.getSintoma());
		this.agregarCompuesto(snodo.getNombreCompuestos());
        this.setSnodoIzq(snodo.getSnodoIzq());
        this.setSnodoDer(snodo.getSnodoDer());
	}
	
	public void igualar(Snodo snodo){
		this.setSintoma(snodo.getSintoma());
		this.agregarCompuesto(snodo.getNombreCompuestos());
        this.setSnodoIzq(snodo.getSnodoIzq());
        this.setSnodoDer(snodo.getSnodoDer());
		this.setEquilibrio(snodo.getEquilibrio());
	}
	
	/**Limpia todos los atributos del objeto para que pueda ser eliminado por el GC*/
	public void limpiar(){
		this.setSintoma(null);
		this.agregarCompuesto();
        this.setSnodoIzq(null);
        this.setSnodoDer(null);
	}
	
	/**Agrega un nuevo compuesto que puede causar el sintoma del Snodo
	   @param nombre_compuesto : nombre del compuesto causante del sintoma
	*/
	public void agregarCompuesto(String nombre_compuesto){
		this.nombre_compuestos.add(nombre_compuesto);
	}
	
	/**Reemplaza los compuestos por una lista de compuestos nueva
	   @param nombre_compuestos : nuevos compuestos que se piensan causan ese sintoma
	*/
	public void agregarCompuesto(Vector<String> nombre_compuestos){
		this.nombre_compuestos=nombre_compuestos;
	}
        
    /**Vuelve null la lista de compuestos*/
	public void agregarCompuesto(){
		this.nombre_compuestos=null;
	}
	
	/**Retorna los compuestos que causan el sintoma del Snodo
	   @return nombre_compuestos : lista de compuestos del Snodo
	*/
	public Vector<String> getNombreCompuestos(){
		return this.nombre_compuestos;
	}
	
	/**Asigna un sintoma al Snodo o Reemplaza el sintoma actual
	   @param sintoma : sintoma nuevo a asignar
	*/
	public void setSintoma(String sintoma){
		this.sintoma=sintoma;
	}
	
	/**Retorna el sintoma asignado al Snodo
	   @return sintoma : sintoma del Snodo
	*/
	public String getSintoma(){
		return this.sintoma;
	}
	
	/**Asigna un hijo izquierdo al Snodo
	   @param izq : nodo izquierdo a asignar
	*/
	public void setSnodoIzq(Snodo izq){
		this.izq=izq;
	}
	
	/**Retorna el hijo izquierdo asociado al Snodo
	   @return izq : Hijo izquierdo del Snodo
	*/
	public Snodo getSnodoIzq(){
		return this.izq;
	}
	
	/**Asigna un hijo derecho al Snodo
	   @param der : nodo derecho a asignar
	*/
	public void setSnodoDer(Snodo der){
		this.der=der;
	}
	
	/**Retorna el hijo derecho asociado al Snodo
	   @return der : Hijo derecho del Snodo
	*/
	public Snodo getSnodoDer(){
		return this.der;
	}
	
	/**Suma un desequilibrio de 1 hacia la derecha*/
	public void equilibrioDer(){
		if(this.equilibrio!=2){
			this.equilibrio += 1;
		}
	}
	
	/**Suma un desequilibrio dado hacia la derecha*/
	public void equilibrioDer(int equilibrio){
		this.equilibrio += equilibrio;
	}
	
	/**Resta un desequilibrio de 1 hacia la izquierda*/
	public void equilibrioIzq(){
		if(this.equilibrio!=-2){
			this.equilibrio -= 1;
		}
	}
	
	/**Resta un desequilibrio dado hacia la izquierda*/
	public void equilibrioIzq(int equilibrio){
		this.equilibrio -= equilibrio;
	}
	
	/**Devueve el valor del equilibrio
	   @return equilibrio : valor del equilibrio
	*/
	public int getEquilibrio(){
		return this.equilibrio;
	}
	
	/**Asigna un equilibrio al snodo
	   @param equilibrio : valor que tomara el equilibrio
	*/
	private void setEquilibrio(int equilibrio){
		this.equilibrio = equilibrio;
	}
	
	/**Calcula el equilibrio del nodo, este resultado sera:
	   -2 : cuando tiene más nodos a la izq que a la derecha, puede haber error al agregar otro a la izquierda
	   -1 : cuando tiene un nodo más a la izq que a la derecha
	    0 : cuando hay la misma cantidad de nodos a la derecha que a la izquierda, por lo que puede haber un error en la siguiente inserción
	    1 : cuando tiene un nodo más a la derecha que a la izquierda
	    2 : cuando tiene más nodos a la der que a la izquierda, puede haber error al agregar otro a la derecha
	   @return Retorna el equilibrio actual del Snodo
	*/
	public int calcularEquilibrio(){
		int izq=0;
		int der=0;
		int resultado=0;
	
		if(this.getSnodoIzq==null){
			der = this.sumaHijos();
		}else if(this.getSnodoDer==null){
			izq = this.sumaHijos();
		}else{
			der = this.sumaHijos();
			izq = this.sumaHijos();
		}
		
		resultado = der-izq;
		
		if(resultado>2){
			return 2;
		}else if(resultado<-2){
			return -2;
		}else{
			return resultado;
		}
	}
	
	/**Suma todos los descendientes de un Snodo
	   @return la cantidad de descendiente que tiene el Snodo
	*/
	private int sumaHijos(){
		int sumai=0;
		int sumad=0;
	
		if(this.getSnodoIzq!=null){
			sumai = (1+this.getSnodoIzq.sumaHijos());
		}
		
		if(this.getSnodoDer!=null){
			sumad = (1+this.getSnodoDer.sumaHijos());
		}
		
		sumad += sumai;
		
		return sumad;
	}
	
	/**Calcula la diferencia de las alturas, entre la altura del lado derecho y el izquierdo
	   @return Retorna la diferencia entre las alturas
	*/
	public int calcularDA(){
		int izq=0;
		int der=0;
		int resultado=0;
	
		if(this.getSnodoIzq==null){
			der = this.altura(this.getSnodoDer);
		}else if(this.getSnodoDer==null){
			izq = this.altura(this.getSnodoIzq);
		}else{
			der = this.altura(this.getSnodoDer);
			izq = this.altura(this.getSnodoIzq);
		}
		
		resultado = der-izq;
		
		return resultado;
	}
	/**Calcula la altura maxima de un snodo
	   @param snodo : snodo al que se le calculara la altura
	   @return Retorna un entero del valor de la altura maxima
	*/
	private int altura(Snodo snodo){
		int suma=0;
	
		if(snodo==null){
			return 0;
		}else{
			return (1+Math.max(snodo.altura(snodo.getSnodoIzq()),snodo.altura(snodo.getSnodoDer())));
		}
	}
}