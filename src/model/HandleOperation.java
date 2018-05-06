package model;

import entity.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by J Michael
 */
public class HandleOperation {

    private static DbManager dbManager;
    private ObjectOutputStream dos;
    private Dato message;

    /**
     * Método Constructor
     */
    public HandleOperation(ObjectOutputStream dos) {
        //dbManager = new DbManager("asico", "root", "michael123");
        this.dos = dos;
    }

    /**
     * @param data
     */
    public void insertBaseCalendar(ArrayList<CalendarioBase> data) throws IOException {
        dbManager.firstInsertCalendarioBase(data);
        message = new Dato("firstInsertCalendarioBase_response", new Boolean(true));
        dos.writeObject(message);
    }

    /**
     * @param data
     */
    public void comprobarCuenta(Map<String, String> data) throws IOException {

        if (data.get("usuario").equalsIgnoreCase("mjl1010") && data.get("clave").equalsIgnoreCase("1234")) {

            Universidad universidad = new Universidad();
            universidad.setId(1);
            universidad.setNombre("UPC");

            Roles rol = new Roles();
            rol.setId(1);
            rol.setNombre("Gestor");
            rol.setColor("#00aa00");
            rol.setPerms("010");

            Usuario usuario = new Usuario();
            usuario.setEmail("mjl1010@gmx.es");
            usuario.setId(1234);
            usuario.setNick("mjl1010");
            //usuario.setPassword("f06eb4703b571d253d7e2b0f526cc20083a1c29ba0eebb395af3751c23e509a74de19021cbc519b29637dff3611e70d4e2a8fdcbe89699f537bc4d908f565b3b97abfa7f1bf2");
            usuario.setPassword("1234");
            usuario.setRol(rol);
            usuario.setUniversidad(universidad);

            Token token = new Token();
            token.setActivo(true);
            token.setCaduca(new Date());
            token.setId(2389478);
            token.setToken("897dyfs87gy89sdfusd98f9sdg");
            token.setUsuario(usuario);
            message = new Dato("firstInsertCalendarioBase_response", token);
        } else {
            message = new Dato("firstInsertCalendarioBase_response", null);
        }
        System.out.println("comprobarCuenta: " + data.get("usuario"));
        dos.writeObject(message);

    }

    /**
     * getPlanificacionCalendarios
     * @param data
     */
    public void getPlanificacionCalendarios(Map<String, Object> data) throws IOException {
        ArrayList<PlanificacionCalendarios> planificacionDias = new ArrayList<>();
        int iWeek = 1;
        for (int i = 1; i<22; i++) {
            if (iWeek == 8) iWeek = 1;

            CalendarioBase cb = new CalendarioBase();
            cb.setActive(true);
            cb.setCursoAcademico((String) data.get("cursoAcademico"));
            cb.setDia(20181000 + i);
            cb.setUniversidad(((Usuario) data.get("usuario")).getUniversidad());

            if (i == 12) cb.setFestivo(true);
            ArrayList<Integer> finSemana = new ArrayList<>((Arrays.asList(6,7,13,14,20,21)));

            cb.setWeekDay(iWeek++);

            PlanificacionCalendarios p1 = new PlanificacionCalendarios();
            PlanificacionCalendarios p2 = new PlanificacionCalendarios();

            if (finSemana.contains(i)) cb.setFestivo(true);
            else {
                Sesion s = new Sesion();
                s.setActivo(true);
                s.setAsignatura("Programació " + i);
                s.setAula("F2G");
                s.setColorFondo("#00aa00");
                s.setColorTexto("#000000");
                s.setConfirmAula(true);
                s.setConfirmContenidos(true);
                s.setConfirmDocente1(true);
                s.setConfirmDocente2(true);
                s.setConfirmWarning(false);
                s.setContenidos("CBO");
                s.setId(200+i);
                s.setMaster1((Master) data.get("master1"));


                if (i % 4 == 1) {
                    // es común
                    p2.setCalendarioBase(cb);
                    p2.setDia(cb.getDia());
                    p2.setMaster((Master) data.get("master2"));
                    p2.setUniversidad(cb.getUniversidad());

                    s.setMaster2(p2.getMaster());
                    s.setNota1("Hola");

                    p2.setSesion(s);
                }

                p1.setSesion(s);
            }

            if (p1.getDia() != 0) planificacionDias.add(p1);
            if (p2.getDia() != 0) planificacionDias.add(p2);
        }
        message = new Dato("getPlanificacionCalendarios", planificacionDias);
    }

    /**
     * return time
     */
    public void getTime() {
        try {

            String msg = "La hora es " + LocalDateTime.now();
            message = new Dato("time", msg);
            dos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCalendariBase_test(Dato message){

        System.out.println("test_object : " + message.toString());

    }
}
