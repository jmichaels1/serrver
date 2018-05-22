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
        //dbManager = new DbManager("asico_db", "asico_dbadmin", "comomola");
        this.dos = dos;
    }

    // APIS

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
     * @param token
     */
    public void comprobarToken(Token token) throws IOException {
        message = new Dato("comprobarToken", token.isActivo());
        System.out.println("comprobarToken");
        dos.writeObject(message);
    }

    // GETTERS

    /**
     * getToken
     * @param token
     */
    public void getToken(String token) throws IOException {
        Token t = new Token();
        if (token.equals("897dyfs87gy89sdfusd98f9sdg")) {
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

            t.setActivo(true);
            t.setCaduca(new Date());
            t.setId(2389478);
            t.setToken("897dyfs87gy89sdfusd98f9sdg");
            t.setUsuario(usuario);
        }
        message = new Dato("comprobarToken", t);
        System.out.println("getToken");
        dos.writeObject(message);
    }

    /**
     * getMasters
     * @param universidad
     */
    public void getMasters(Universidad universidad) throws IOException {
        ArrayList<Master> masters = new ArrayList<>();
        int i = 100;

        Master m1 = new Master(i++*3, "M-SAP-ERP", "Máster SAP en Sistemas de Información Integrados (ERP) - UPM");
        Master m2 = new Master(i++*3, "M-NUT-BIO-ALI", "Máster en Nutrición y Biotecnología Alimentaria");
        Master m3 = new Master(i++*3, "M-DIR-OPE-INN", "Máster en Dirección de Operaciones e Innovación");
        Master m4 = new Master(i++*3, "M-ING-IND", "Máster en Ingeniería Industrial");
        Master m5 = new Master(i++*3, "M-ACT-FIS-ENT-GES-DEP", "Máster en Actividad física: Entrenamiento y gestión deportiva");
        Master m6 = new Master(i++*3, "M-ACT-FIS-SAL", "Máster en Actividad Física y Salud");
        m5.setMasterVinculado(m6); m6.setMasterVinculado(m5);
        Master m7 = new Master(i++*3, "M-GER-SOC", "Máster en Gerontología Social");
        Master m8 = new Master(i++*3, "M-CIE-TEC-MAR", "Máster en Ciencia y Tecnología Marina");
        Master m9 = new Master(i++*3, "M-DER-NEG-INT", "Máster en Derecho y Negocios Internacionales");
        Master m10 = new Master(i++*3, "MA-DIR-FOT", "Máster anual de Dirección de fotografía");
        Master m11 = new Master(i++*3, "MC-DIE-SEG-ALI-COL", "Máster en Dietética y seguridad alimentaria para colectividades (Certificado por la Cátedra Ferran Adrià)");
        Master m12 = new Master(i++*3, "M-DIS-GES-DIR-PRO", "Máster en Diseño, Gestión y Dirección de Proyectos");
        Master m13 = new Master(i++*3, "M-PSI-COM", "Máster en Psicología del Comportamiento");
        Master m14 = new Master(i++*3, "M-EST-BIO-NAT-ACU", "Máster en Estudios Biologico Naturistas en Acupuntura");
        Master m15 = new Master(i++*3, "M-GES-ADM-FIN", "Máster en Gestión Administrativa y Financiera");
        Master m16 = new Master(i++*3, "M-GES-AUD-AMB", "Máster en Gestión y Auditorias Ambientales");
        Master m17 = new Master(i++*3, "M-DIR-CIN", "Máster de Dirección de cine");
        Master m18 = new Master(i++*3, "M-ADM-GES-EMP", "Máster en Administración y Gestión de Empresas");
        Master m19 = new Master(i++*3, "M-DIR-CON-TUR", "Máster en Dirección y Consultoría Turística");
        Master m20 = new Master(i++*3, "M-NEG-CHI-ASIPAC", "Máster en Negocios con China y Asia-Pacífico");
        Master m21 = new Master(i++*3, "MCO-ADM-DBO", "Máster Administración de la Base de Datos Oracle v.12c - Oracle Certified Professional");
        Master m22 = new Master(i++*3, "M-SEX-CLI-TER-PAR", "Máster en Sexología Clínica y Terapia de Parejas (ISEP Barcelona)");
        Master m23 = new Master(i++*3, "M-DIR-MAR-GES-COM", "Master en Dirección de Marketing y Gestión Comercial");
        Master m24 = new Master(i++*3, "M-SEC-INT-ALT-DIR", "Máster Secretariado Internacional de Alta Dirección (Barcelona)");
        Master m25 = new Master(i++*3, "M-EXE-MBA", "Executive MBA");
        Master m26 = new Master(i++*3, "M-DIR-GES-PRO-MOD", "Máster de Dirección y Gestión de Producto de Moda");
        Master m27 = new Master(i++*3, "M-CIU-HER-CRO", "Máster en Cuidados de Heridas Crónicas");
        Master m28 = new Master(i++*3, "ME-BUS-MAN", "Master in Business Management (English)");
        Master m29 = new Master(i++*3, "MM-AUT-MAN-IND", "Doble máster en Automatización y Mantenimiento industrial");
        Master m30 = new Master(i*3, "ME-INT-BUS-MAN", "Máster en International Business Management (English)");
        m28.setMasterVinculado(m30); m30.setMasterVinculado(m28);

        masters.add(m1);
        masters.add(m2);
        masters.add(m3);
        masters.add(m4);
        masters.add(m5);
        masters.add(m6);
        masters.add(m7);
        masters.add(m8);
        masters.add(m9);
        masters.add(m10);
        masters.add(m11);
        masters.add(m12);
        masters.add(m13);
        masters.add(m14);
        masters.add(m15);
        masters.add(m16);
        masters.add(m17);
        masters.add(m18);
        masters.add(m19);
        masters.add(m20);
        masters.add(m21);
        masters.add(m22);
        masters.add(m23);
        masters.add(m24);
        masters.add(m25);
        masters.add(m26);
        masters.add(m27);
        masters.add(m28);
        masters.add(m29);
        masters.add(m30);

        message = new Dato("getMasters", masters);
        System.out.println("getMasters");
        dos.writeObject(message);
    }

    /**
     * Select distinct curso_academico from CalendarioBase where universidad
     * getCursos
     * @param universidad
     */
    public void getCursos(Universidad universidad) throws IOException {
        ArrayList<String> cursos = new ArrayList<>();
        for (int i = 2000; i<2018; i++) cursos.add(i + "-" + (i+1));
        message = new Dato("getCursos", cursos);
        System.out.println("getCursos");
        dos.writeObject(message);
    }

    /**
     * getPlanificacionCalendarios
     * @param data
     */
    public void getPlanificacionCalendarios(Map<String, Object> data) throws IOException {
        ArrayList<DiaPlanificado> planificacionDias = new ArrayList<>();
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

            DiaPlanificado p1 = new DiaPlanificado();
            DiaPlanificado p2 = new DiaPlanificado();

            p1.setCalendarioBase(cb);
            p1.setDia(cb.getDia());
            p1.setMaster((Master) data.get("master1"));
            p1.setUniversidad(cb.getUniversidad());

            p2.setCalendarioBase(cb);
            p2.setDia(cb.getDia());
            p2.setMaster((Master) data.get("master2"));
            p2.setUniversidad(cb.getUniversidad());

            if (finSemana.contains(i)) cb.setFestivo(true);
            else {
                Sesion s = new Sesion();
                s.setActivo(true);
                s.setAsignatura("Programació " + i*10);
                s.setAula("F"+i+"G");
                s.setColorFondo("#00aa00");
                s.setColorTexto("#000000");
                s.setConfirmAula(true);
                s.setConfirmContenidos(true);
                s.setConfirmDocente1(true);
                s.setConfirmDocente2(true);
                s.setConfirmWarning(false);
                s.setContenidos("CBO " + i*30);
                s.setId(200+i);
                s.setMaster1((Master) data.get("master1"));
                s.setTipoAula("S");

                if (i % 4 == 1) {
                    // es común
                    s.setMaster2(p2.getMaster());
                    s.setNota1("Hola");
                    s.setTipoAula("L");

                    p2.setSesion(s);
                }

                p1.setSesion(s);
            }

            planificacionDias.add(p1);
            planificacionDias.add(p2);
        }
        System.out.println("getPlanificacionCalendarios");
        message = new Dato("getPlanificacionCalendarios", planificacionDias);
        dos.writeObject(message);
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

    // SETTERS

    /**
     * @param token
     */
    public void logoutToken(Token token) throws IOException {
        token.setActivo(false);
        System.out.println("logoutToken");
        message = new Dato("logoutToken", Boolean.TRUE);
        dos.writeObject(message);
    }

    /**
     * @param data
     */
    public void insertBaseCalendar(ArrayList<CalendarioBase> data) throws IOException {
        dbManager.firstInsertCalendarioBase(data);
        message = new Dato("firstInsertCalendarioBase_response", Boolean.TRUE);
        dos.writeObject(message);
    }
}
