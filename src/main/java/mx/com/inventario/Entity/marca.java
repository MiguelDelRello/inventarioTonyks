package mx.com.inventario.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity(name =  "marca")
@Table(name = "marca")
public class marca {


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name ="id_marca")
	private String id_marca;
	@Column(name ="nombre")
	private String nombre;
	@Column(name ="descripcion")
	private String descripcion;
	
	
	public String getIdMarca() {
		return id_marca;
	}
	public void setIdMarca(String idMarca) {
		this.id_marca = idMarca;
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
		return "Marca [idMarca=" + id_marca + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
}
