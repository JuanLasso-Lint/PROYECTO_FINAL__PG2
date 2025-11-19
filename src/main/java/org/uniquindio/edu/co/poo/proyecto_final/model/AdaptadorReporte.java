package org.uniquindio.edu.co.poo.proyecto_final.model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class AdaptadorReporte implements ReportePDF {

    private ReporteViejo reporteViejo;

    public AdaptadorReporte(ReporteViejo reporteViejo) {
        this.reporteViejo = reporteViejo;
    }

    @Override
    public void generarReporte() {
        try {
            Document documento = new Document();
            String nombreArchivo = "Reporte_" + reporteViejo.getNombreReporte() + ".pdf";

            PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));
            documento.open();

            documento.add(new Paragraph("=== REPORTE PDF GENERADO ==="));
            documento.add(new Paragraph("Nombre: " + reporteViejo.getNombreReporte()));
            documento.add(new Paragraph("Fecha: " + reporteViejo.getFecha()));
            documento.add(new Paragraph("Contenido:"));
            documento.add(new Paragraph(reporteViejo.getContenido()));

            documento.close();

            System.out.println("PDF generado correctamente: " + nombreArchivo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void imprimirReporte() {
        // Aqui podrías mandar a imprimir usando Desktop.getDesktop().print()
        System.out.println("Simulando impresión de PDF...");
        reporteViejo.imprimir();
    }

    public ReporteViejo getReporteViejo() { return reporteViejo; }

    public void setReporteViejo(ReporteViejo reporteViejo) { this.reporteViejo = reporteViejo; }
}