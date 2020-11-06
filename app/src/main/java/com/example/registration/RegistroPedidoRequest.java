package com.example.registration;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroPedidoRequest extends StringRequest {
    private static final String REGISTER_REQUESTE_URL="http://192.168.43.220/Registro_usuario_Prueba/registrarPedido.php";
    private Map<String, String> params;
    public RegistroPedidoRequest(String personaEntrega, String cantidad, String fecha, String precio, String nombre, String telefono, Response.Listener<String> listener) {
        super(Request.Method.POST,REGISTER_REQUESTE_URL,listener,null);
        params= new HashMap<>();
        params.put("personaEntrega",personaEntrega);
        params.put("cantidad",cantidad);
        params.put("fecha",fecha);
        params.put("precio",precio);
        params.put("nombre",nombre);
        params.put("telefono",telefono);


    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
