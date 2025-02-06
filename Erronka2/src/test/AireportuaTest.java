package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloa.Aireportua;

public class AireportuaTest {

	private Aireportua aireportua1 = new Aireportua("124", "AeropuertoTest");

    @Test
    public void testConstructor() {
        // Verificamos que el constructor asigna correctamente los valores a los atributos
        assertEquals("124", aireportua1.getIdentifikatzailea());
        assertEquals("AeropuertoTest", aireportua1.getIzena());
    }

    @Test
    public void testGetSetIdentifikatzailea() {
        aireportua1.setIdentifikatzailea("456");
        assertEquals("456", aireportua1.getIdentifikatzailea());
    }

    @Test
    public void testGetSetIzena() {
        aireportua1.setIzena("Nuevo Aeropuerto");
        assertEquals("Nuevo Aeropuerto", aireportua1.getIzena());
    }

    @Test
    public void testToString() {
        // Verificamos que el método toString devuelve la cadena correcta
        String expectedString = "Aireportua [identifikatzailea=124, izena=AeropuertoTest]";
        assertEquals(expectedString, aireportua1.toString());
    }

    @Test
    public void testToStringAfterSet() {
        // Verificamos que el método toString devuelva la cadena correcta después de modificar los valores
        aireportua1.setIdentifikatzailea("789");
        aireportua1.setIzena("Aeropuerto Modificado");
        String expectedString = "Aireportua [identifikatzailea=789, izena=Aeropuerto Modificado]";
        assertEquals(expectedString, aireportua1.toString());
    }
}
