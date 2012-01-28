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
		this.setCompuesto(snodo.getNombreCompuestos());
        this.setSnodoIzq(snodo.getSnodoIzq());
        this.setSnodoDer(snodo.getSnodoDer());
	}
	
	public void igualar(Snodo snodo){
		this.setSintoma(snodo.getSintoma());
		this.setCompuesto(snodo.getNombreCompuestos());
        this.setSnodoIzq(snodo.getSnodoIzq());
        this.setSnodoDer(snodo.getSnodoDer());
		this.setEquilibrio(snodo.getEquilibrio());
	}
	
	/**Limpia todos los atributos del objeto para que pueda ser eliminado por el GC*/
	public void limpiar(){
		this.setSintoma(null);
		this.setCompuesto(null);
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
	
	public void equilibrioDer(){
		if(this.equilibrio!=2){
			this.equilibrio += 1;
		}
	}
	
	public void equilibrioDer(int equilibrio){
		this.equilibrio += equilibrio;
	}
	
	public void equilibrioIzq(){
		if(this.equilibrio!=-2){
			this.equilibrio -= 1;
		}
	}
	
	public void equilibrioIzq(int equilibrio){
		this.equilibrio -= equilibrio;
	}
	
	public int getEquilibrio(){
		return this.equilibrio;
	}
	
	private void setEquiligrio(int equilibrio){
		this.equilibrio = equilibrio
	}

}
