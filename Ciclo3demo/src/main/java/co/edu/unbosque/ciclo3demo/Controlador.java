package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
//@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
	private static final Long serialVersionUID = 1L;
	
	//********Variables Generales****************	
	double subtotal = 0, totalapagar = 0;
	long codProducto = 0;  
	double valor_iva=0, precio=0, iva=0, subtotaliva=0, acusubtotal=0;
	long numfac=0;
	int cantidad=0, item=0;
	String descripcion, cedulaCliente;
	List<Detalle_venta> listaVentas = new ArrayList<>();
	Usuarios usuarios = new Usuarios();
	Detalle_venta detalle_venta = new Detalle_venta();
	//*******************************************
	
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//************Metodos locales dentro de la clase Controlador******************
	
	public void buscarCliente(String id, HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try {
			ArrayList<Clientes> listac = TestJSONClientes.getJSON();			
			for (Clientes clientes: listac) {
				if(clientes.getCedula_cliente().equals(id)) {
					request.setAttribute("clienteSeleccionado", clientes);				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarProducto(String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				ArrayList<Productos> listap = TestJSONProductos.getJSON();
				for (Productos productos: listap) {
					if(productos.getCodigo_producto().equals(id)) {
						request.setAttribute("productoSeleccionado", productos);						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void mostrarNumFactura(String numFact, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			if(numFact == null) {
				
				
					numFact = "1";
				
				numfac = Integer.parseInt(numFact);
			}else {
				numfac = Integer.parseInt(numFact) + 1;
				
			}
			request.setAttribute("numerofactura", numfac);
		}
	
	public void grabarDetalle_Ventas (Long numFact, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		for(int i = 0; i<listaVentas.size(); i++) {
			detalle_venta = new Detalle_venta();
			detalle_venta.setCodigo_detalle_venta(i+1);
			detalle_venta.setCodigo_venta(numFact);
			detalle_venta.setCodigo_producto(listaVentas.get(i).getCodigo_producto());
			detalle_venta.setCantidad_producto(listaVentas.get(i).getCantidad_producto());
			detalle_venta.setValor_venta(listaVentas.get(i).getValor_venta());
			detalle_venta.setValor_total(listaVentas.get(i).getValor_total());
			detalle_venta.setValor_iva(listaVentas.get(i).getValor_iva());
			
			int respuesta = 0;
			
			try {
				respuesta = TestJSONDetalleVenta.postJSON(detalle_venta);
				PrintWriter write = response.getWriter();
				if(respuesta == 200) {
					System.out.println("Registro grabado en Detalle Ventas: " + i);
					request.getRequestDispatcher("Controlador?menu=Ventas&accion=default").forward(request, response);
				}else {
					write.println("Error Detalle Ventas: " + respuesta);
				}
				write.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
	}
	
	//****************************************************************************

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
				
		switch (menu) {
		case "Principal":			
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
			break;
		case "Usuarios":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Usuarios> lista = TestJSON.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Usuarios usuario = new Usuarios();
				usuario.setCedula_usuario(request.getParameter("txtcedula"));
				usuario.setNombre_usuario(request.getParameter("txtnombre"));
				usuario.setEmail_usuario(request.getParameter("txtemail"));
				usuario.setUsuario(request.getParameter("txtusuario"));
				usuario.setPassword(request.getParameter("txtpassword"));

				int respuesta = 0;
				try {
					respuesta = TestJSON.postJSON(usuario);
					PrintWriter write = null;
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Usuarios usuario = new Usuarios();
				usuario.setCedula_usuario(request.getParameter("txtcedula"));
				usuario.setNombre_usuario(request.getParameter("txtnombre"));
				usuario.setEmail_usuario(request.getParameter("txtemail"));
				usuario.setUsuario(request.getParameter("txtusuario"));
				usuario.setPassword(request.getParameter("txtpassword"));

				int respuesta = 0;
				try {
					respuesta = TestJSON.putJSON(usuario, Long.parseLong(usuario.getCedula_usuario()));
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				String id = request.getParameter("id");			
				try {
					ArrayList<Usuarios> lista1 = TestJSON.getJSON();
					System.out.println("Parametro: " + id);
					for (Usuarios usuarios : lista1) {
						if (usuarios.getCedula_usuario().equals(id)) {
							request.setAttribute("usuarioSeleccionado", usuarios);
							request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = TestJSON.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
			break;
		
		case "Clientes":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Clientes> lista = TestJSONClientes.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Clientes cliente = new Clientes();
				cliente.setCedula_cliente(request.getParameter("txtcedula"));
				cliente.setNombre_cliente(request.getParameter("txtnombre"));
				cliente.setEmail_cliente(request.getParameter("txtemail"));
				cliente.setDireccion_cliente(request.getParameter("txtdireccion"));
				cliente.setTelefono_cliente(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = TestJSONClientes.postJSON(cliente);
					PrintWriter write = null;
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Clientes cliente = new Clientes();
				cliente.setCedula_cliente(request.getParameter("txtcedula"));
				cliente.setNombre_cliente(request.getParameter("txtnombre"));
				cliente.setEmail_cliente(request.getParameter("txtemail"));
				cliente.setDireccion_cliente(request.getParameter("txtdireccion"));
				cliente.setTelefono_cliente(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = TestJSONClientes.putJSON(cliente, Long.parseLong(cliente.getCedula_cliente()));
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				String id = request.getParameter("id");
				try {
					ArrayList<Clientes> lista1 = TestJSONClientes.getJSON();
					System.out.println("Parametro: " + id);
					for (Clientes clientes : lista1) {
						if (clientes.getCedula_cliente().equals(id)) {
							request.setAttribute("clienteSeleccionado", clientes);
							request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = TestJSONClientes.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
			break;
		case "Proveedores":
			
			if (accion.equals("Listar")) {
				try {
					ArrayList<Proveedores> lista = TestJSONProveedores.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNitproveedor((request.getParameter("txtnit")));
				proveedor.setCiudad_proveedor(request.getParameter("txtciudad"));
				proveedor.setDireccion_proveedor(request.getParameter("txtdireccion"));
				proveedor.setNombre_proveedor(request.getParameter("txtnombre"));
				proveedor.setTelefono_proveedor(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = TestJSONProveedores.postJSON(proveedor);
					PrintWriter write = null;
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNitproveedor(request.getParameter("txtnit"));
				proveedor.setCiudad_proveedor(request.getParameter("txtciudad"));
				proveedor.setDireccion_proveedor(request.getParameter("txtdireccion"));
				proveedor.setNombre_proveedor(request.getParameter("txtnombre"));
				proveedor.setTelefono_proveedor(request.getParameter("txttelefono"));

				int respuesta = 0;
				try {
					respuesta = TestJSONProveedores.putJSON(proveedor, Long.parseLong(proveedor.getNitproveedor()));
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				String id = request.getParameter("id");
				try {
					ArrayList<Proveedores> lista = TestJSONProveedores.getJSON();
					System.out.println("Parametro: " + id);
					for (Proveedores proveedor : lista) {
						if (proveedor.getNitproveedor().equals(id)) {
							request.setAttribute("proveedorSeleccionado", proveedor);
							request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = TestJSONProveedores.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
			break;
		case "Productos":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Productos> lista = TestJSONProductos.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Productos producto = new Productos();
				producto.setCodigo_producto(request.getParameter("txtcodigoproducto"));
				producto.setIvacompra(request.getParameter("txtivacompra"));
				producto.setNitproveedor(request.getParameter("txtnitproveedor"));
				producto.setNombre_producto(request.getParameter("txtnombreproducto"));
				producto.setPrecio_compra(request.getParameter("txtpreciocompra"));
				producto.setPrecio_venta(request.getParameter("txtprecioventa"));

				int respuesta = 0;
				try {
					respuesta = TestJSONProductos.postJSON(producto);
					PrintWriter write = null;
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Productos producto = new Productos();
				producto.setCodigo_producto(request.getParameter("txtcodigoproducto"));
				producto.setIvacompra(request.getParameter("txtivacompra"));
				producto.setNitproveedor(request.getParameter("txtnitproveedor"));
				producto.setNombre_producto(request.getParameter("txtnombreproducto"));
				producto.setPrecio_compra(request.getParameter("txtpreciocompra"));
				producto.setPrecio_venta(request.getParameter("txtprecioventa"));

				int respuesta = 0;
				try {
					respuesta = TestJSONProductos.putJSON(producto, Long.parseLong(producto.getCodigo_producto()));
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				String id = request.getParameter("id");
				try {
					ArrayList<Productos> lista1 = TestJSONProductos.getJSON();
					System.out.println("Parametro: " + id);
					for (Productos productos : lista1) {
						if (productos.getCodigo_producto().equals(id)) {
							request.setAttribute("productoSeleccionado", productos);
							request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = TestJSONProductos.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/Productos.jsp").forward(request, response);
			break;
		case "Ventas":
			//************Cedula del Usuario Activo *****************
			String cedula_usuario_activo = request.getParameter("UsuarioActivo");
			usuarios.setCedula_usuario(cedula_usuario_activo);
			request.setAttribute("usuarioSeleccionado", usuarios);
			//*******************************************************
			
			//**********Enviar al formulario de ventas la cédula del usuario y numero de factura**************
			request.setAttribute("usuarioSeleccionado", usuarios);
			request.setAttribute("numerofactura", numfac);
			//****************************************************************************
			
			if(accion.equals("BuscarCliente")) {				
				String id = request.getParameter("cedulacliente");				
				this.buscarCliente(id, request, response);
				
			} else if (accion.equals("BuscarProducto")) {				
				String id = request.getParameter("codigoproducto");				
				this.buscarProducto(id, request, response);
				//**********Volver a buscar los datos del cliente**************
				String idc = request.getParameter("cedulacliente");				
				this.buscarCliente(idc, request, response);
				//*************************************************************
			} else if(accion.equals("AgregarProducto")) {
				//**********Volver a buscar los datos del cliente**************
				String idc = request.getParameter("cedulacliente");				
				this.buscarCliente(idc, request, response);
				//*************************************************************
				detalle_venta = new Detalle_venta();
				item++;
				totalapagar = 0;
				acusubtotal = 0;
				subtotaliva = 0;
				
				codProducto = Integer.parseInt(request.getParameter("codigoproducto"));
				descripcion = request.getParameter("nombreproducto");
				precio = Double.parseDouble(request.getParameter("precioproducto"));
				cantidad = Integer.parseInt(request.getParameter("cantidadproducto"));
				iva = Double.parseDouble(request.getParameter("ivaproducto"));
				
				subtotal = (precio*cantidad);
				valor_iva = (subtotal*iva)/100;
				
				detalle_venta.setCodigo_detalle_venta(item);
				detalle_venta.setCodigo_producto(codProducto);
				detalle_venta.setDescripcion_producto(descripcion);
				detalle_venta.setCantidad_producto(cantidad);
				detalle_venta.setPrecio_producto(precio);
				detalle_venta.setCodigo_venta(numfac);
				detalle_venta.setValor_iva(valor_iva);
				detalle_venta.setValor_venta(subtotal);
				listaVentas.add(detalle_venta);
				
				for(int i=0; i<listaVentas.size(); i++) {
					acusubtotal += listaVentas.get(i).getValor_venta();
					subtotaliva += listaVentas.get(i).getValor_iva();
					
				}
				
				totalapagar = acusubtotal + subtotaliva;
				detalle_venta.setValor_total(totalapagar);
				
				request.setAttribute("listaventas", listaVentas);
				request.setAttribute("totalsubtotal", acusubtotal);
				request.setAttribute("totaliva", subtotaliva);
				request.setAttribute("totalapagar", totalapagar);
			
			}else if(accion.equals("GenerarVenta")) {
				//**************Guardar en la BD Ventas************
				String numfact = request.getParameter("numerofactura");
				cedulaCliente = request.getParameter("cedulacliente");
				
				Ventas ventas = new Ventas();
				ventas.setCodigo_venta(Long.parseLong(numfact));
				ventas.setCedula_cliente(Long.parseLong(cedulaCliente));
				ventas.setCedula_usuario(Long.parseLong(usuarios.getCedula_usuario()));
				
				ventas.setIva_venta(subtotaliva);
				ventas.setValor_venta(acusubtotal);
				ventas.setTotal_venta(totalapagar);				
				
				int respuesta = 0;
				
				try {
					respuesta = TestJSONVentas.postJSON(ventas);
					PrintWriter write = response.getWriter();
					
					if(respuesta == 200) {
						System.out.println("Grabación Exitosa" + respuesta);
						this.grabarDetalle_Ventas(ventas.getCodigo_venta(), request, response);
					}else {
						write.println("Error Ventas: " + respuesta);
					}
					write.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				//*************************************************
				
				listaVentas.clear();
				
				item = 0;
				totalapagar = 0;
				acusubtotal = 0;
				subtotaliva = 0;
				
			}else {
				//********Muestro por primera vez numero de factura****
				String factura = request.getParameter("numerofactura");
				this.mostrarNumFactura(factura, request, response);
			}
			
			request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
			break;
		case "Reportes":
			int opcion = 0;
			if(accion.equals("ReporteUsuarios")) {
				try {
					ArrayList<Usuarios> lista = TestJSON.getJSON();
					opcion=1;
					request.setAttribute("listaUsuarios", lista);
					request.setAttribute("opcion", opcion);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (accion.equals("ReporteClientes")) {
				try {
					ArrayList<Clientes> lista = TestJSONClientes.getJSON();
					opcion=2;
					request.setAttribute("listaClientes", lista);
					request.setAttribute("opcion", opcion);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("ReporteVentas")) {
				try {
					ArrayList<Ventas> lista = TestJSONVentas.getJSON();
					opcion=3;
					request.setAttribute("listaVentas", lista);
					request.setAttribute("opcion", opcion);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/Reportes.jsp").forward(request, response);
			break;
		}
	}
}








