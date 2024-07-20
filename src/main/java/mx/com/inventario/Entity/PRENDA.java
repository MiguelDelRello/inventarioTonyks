package mx.com.inventario.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "PRENDA")
@Table  (name = "prenda")
public class PRENDA {

	public PRENDA(Integer idPrenda, String marca, String talla, double costo, double venta, String modelo, String tipo,
			Integer stock, String descripcion, String imagen) {
		super();
		this.idPrenda = idPrenda;
		this.marca = marca;
		this.talla = talla;
		this.costo = costo;
		this.venta = venta;
		this.modelo = modelo;
		this.tipo = tipo;
		this.stock = stock;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPrenda")
	private Integer idPrenda; 
	@Column(name = "idMarca")
	private String marca; 
	@Column(name = "talla")
	private String talla;
	@Column(name = "costo")
	private double costo;
	@Column(name = "venta")
	private double venta;
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
		// TODO Auto-generated constructor stub
	}
	public Integer getIdPrenda() {
		return idPrenda;
	}
	public void setIdPrenda(Integer idPrenda) {
		this.idPrenda = idPrenda;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String string) {
		this.marca = string;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public double getVenta() {
		return venta;
	}
	public void setVenta(double venta) {
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
		return "PRENDA [idPrenda=" + idPrenda + ", marca=" + marca + ", talla=" + talla + ", costo=" + costo
				+ ", venta=" + venta + ", modelo=" + modelo + ", tipo=" + tipo + ", stock=" + stock + ", descripcion=" + descripcion + "]";
	}
	
	
}
