
  package edu.usal.controller.console;
  
  import java.io.FileNotFoundException; import java.io.IOException; import
  java.util.List;
  
  import edu.usal.negocio.dao.Factory.VueloFactory; import
  edu.usal.negocio.dao.interfaces.VueloDAO; import
  edu.usal.negocio.dominio.Vuelos; import edu.usal.util.IOGeneral; import
  edu.usal.view.console.MenuVistaVuelo;
  
  public class MenuControllerVuelo {
  
  MenuVistaVuelo vistaVuelo; VueloDAO vueloDAO;
  
  public MenuControllerVuelo() { vistaVuelo = new MenuVistaVuelo();
  this.MostrarMenu(); }
  
  public void MostrarMenu() { int res = -1; while(res!=0){ res=
  vistaVuelo.ImprimirMenu(); switch(res){ case 1: addVuelo(); break; case 2:
  queryVuelo(); break; case 3: updateVuelo(); break; case 4: deleteVuelo();
  break; case 0: break; default: IOGeneral.pritln("Numero Equivocado"); } } }
  
  private void addVuelo() {
  
  Vuelos vuelo = vistaVuelo.PedirVuelos(); vueloDAO =
  VueloFactory.getVueloDAO("Serializable"); try { if(vueloDAO.addVuelo(vuelo))
  { vistaVuelo.OperacionExitosa(); }else { vistaVuelo.OperacionFail(); } }
  catch (FileNotFoundException e) {
  vistaVuelo.LugarError("Archivo No Encontrado", e.getLocalizedMessage()); }
  catch (IOException e) { vistaVuelo.LugarError("Entrada/Salida De Datos",
  e.getLocalizedMessage()); }
  
  
  } private void queryVuelo() {
  
  try { vueloDAO = VueloFactory.getVueloDAO("Serializable"); List<Vuelos> vuelo
  = vueloDAO.getAllVuelos(); vistaVuelo.MostrarLista(vuelo); } catch
  (FileNotFoundException e) { vistaVuelo.LugarError("Archivo No Encontrado",
  e.getLocalizedMessage()); } catch (IOException e) {
  vistaVuelo.LugarError("Entrada/Salida De Datos", e.getLocalizedMessage()); }
  } private void updateVuelo() {
  
		/*
		 * try { vueloDAO = VueloFactory.getVueloDAO("Serializable"); Vuelos
		 * vueloModificar = new Vuelos (null, null,
		 * vistaVuelo.PedirID("Modificar Vuelo"), 0, null, null, null, null);
		 * vueloModificar = vueloDAO.queryVuelo(vueloModificar); if(vueloModificar !=
		 * null) { if(vistaVuelo.Confirmacion(vueloModificar)) {
		 * if(vueloDAO.updateVuelo(vueloModificar)) {
		 * 
		 * vistaVuelo.OperacionExitosa(); } else { vistaVuelo.OpcionFail(); } } else {
		 * vistaVuelo.CancelarOperacion(); } } else {
		 * vistaVuelo.LugarError("Vuelo No Modificado", "No Se Encontro el Id"); } }
		 * catch (FileNotFoundException e) {
		 * vistaVuelo.LugarError("Archivo No Encontrado", e.getLocalizedMessage()); }
		 * catch (IOException e) { vistaVuelo.LugarError("Entrada/Salida De Datos",
		 * e.getLocalizedMessage()); }
		 */ } 
  private void deleteVuelo() {
  
		/*
		 * try { vueloDAO = VueloFactory.getVueloDAO("Serializable"); Vuelos
		 * vueloEliminar = new Vuelos(null, null, vistaVuelo.PedirID("Eliminar Vuelo"),
		 * 0, null, null, null, null); vueloEliminar =
		 * vueloDAO.queryVuelo(vueloEliminar); if(vueloEliminar != null) {
		 * if(vistaVuelo.Confirmacion(vueloEliminar)) {
		 * if(vueloDAO.deleteVuelo(vueloEliminar)) { vistaVuelo.OperacionExitosa();
		 * }else { vistaVuelo.OpcionFail(); } }else { vistaVuelo.CancelarOperacion(); }
		 * }else { vistaVuelo.LugarError("Vuelo No Eliminado","No Se Encontro El Id" );
		 * } } catch (FileNotFoundException e) {
		 * vistaVuelo.LugarError("Archivo No Encontrado", e.getLocalizedMessage()); }
		 * catch (IOException e) { vistaVuelo.LugarError("Entrada/Salida De Datos",
		 * e.getLocalizedMessage()); }
		 */ }
  
  }
 
