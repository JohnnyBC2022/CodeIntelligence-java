package permission.model;

public class PermissionEntity {
    /*
    - nombre (String): Nombre del permiso.
     */

    private String name;

    public PermissionEntity(String name) {
        this.name = name;
    }

    public PermissionEntity(){

    }

    public String getName(){
        return  name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "PermissionEntitiy{" +
                "name='" + name + '\'' +
                '}';
    }
}
