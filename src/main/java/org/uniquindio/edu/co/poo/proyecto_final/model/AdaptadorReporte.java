package org.uniquindio.edu.co.poo.proyecto_final.model;

public class AdaptadorReporte implements ReportePDF {

    private ReporteViejo reporteViejo;

    public AdaptadorReporte(ReporteViejo reporteViejo) {
        this.reporteViejo = reporteViejo;
    }

    @Override
    public void generarReporte() {
        System.out.println("Reporte Generado!");
        reporteViejo.generar();
    }

    @Override
    public void imprimirReporte() {
        System.out.println("Reporte Impreso");
        reporteViejo.imprimir();
    }

    public ReporteViejo getReporteViejo() {
        return reporteViejo;
    }

    public void setReporteViejo(ReporteViejo reporteViejo) {
        this.reporteViejo = reporteViejo;
    }
}