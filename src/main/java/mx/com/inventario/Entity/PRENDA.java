package mx.com.inventario.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder
@Entity (name = "PRENDA")
@Table  (name = "prenda")
public class PRENDA {

	public PRENDA(Integer id_prenda, Integer id_marca, String talla, double costo, Integer venta, String modelo, String tipo,
			Integer stock, String descripcion, String imagen) {
		super();
		this.id_prenda = id_prenda;
		this.id_marca = id_marca;
		this.talla = talla;
		this.costo = costo;
		this.venta = venta;
		this.modelo = modelo;
		this.tipo = tipo;
		this.stock = stock;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}



	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_prenda")
	private Integer id_prenda; 
	@Column(name = "id_marca")
	private Integer id_marca; 
	@Column(name = "talla")
	private String talla;
	@Column(name = "costo")
	private double costo;
	@Column(name = "venta")
	private Integer venta;
	@Column(name = "modelo")
	private String modelo;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "stock")
	private Integer stock;
	@Column(name = "descripcion")
	private String descripcion;
    @Column(name = "imagen")
    private String imagen;
	
	public PRENDA() {
	}
	public Integer getIdPrenda() {
		return id_prenda;
	}
	public void setIdPrenda(Integer idPrenda) {
		this.id_prenda = idPrenda;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Integer getMarca() {
		return id_marca;
	}
	public void setMarca(Integer string) {
		this.id_marca = string;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public Integer getVenta() {
		return venta;
	}
	public void setVenta(Integer venta) {
		this.venta = venta;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	@Override
	public String toString() {
		return "PRENDA [id_prenda=" + id_prenda + ", id_marca=" + id_marca + ", talla=" + talla + ", costo=" + costo
				+ ", venta=" + venta + ", modelo=" + modelo + ", tipo=" + tipo + ", stock=" + stock + ", descripcion=" + descripcion +  ", imagen=" + imagen +  "]";
	}
	
	
}
