package mx.com.inventario.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity(name = "marca")
@Table(name = "marca")
public class marca {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idMarca")
	private String idMarca;
	@Column(name ="nombre")
	private String nombre;
	@Column(name ="descripcion")
	private String descripcion;
	
	
	public String getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(String idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Marca [idMarca=" + idMarca + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
}
