package costome.marker.interfacedmo;

public class FunctionalityClass {
    
    public static void isMarker(Object object){
	if(object instanceof ImplementsOracleMarkerInterfaceClass){
	    System.out.println("Connect Oracle.....");
	}
	
	if(object instanceof ImplementsSQLMarkerInterfaceClass){
	    System.out.println("Connect SQL.....");
	}
    }

}
