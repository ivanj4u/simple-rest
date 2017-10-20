/*
 * Copyright (c) 2017.
 */

package com.aribanilia.rest.simple.logger.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_REST_LOG_ECHANNEL")
public class TblLRestLogEChannel implements Cloneable {
    private long id;
    private String clientId;
    private String channelId;
    private Date timeRequest;
    private Date timeResponse;
    private String responseCode;
    private String responseDesc;
    private String billKey1; //norek atau cif
    private String billKey2; //jenisTransaksi
    private String billKey3; //amount
    private String requestType;
    private String reffSwitching;
    private String reffCore; //jurnalId
    private String productName;
    private String customerName;
    private double up;
    private double sisaUp;
    private Date tglKredit;
    private Date tglJatuhTempo;
    private String jmlHariTarif;
    private String jmlHariReal;
    private String tenor;
    private String sisaTenor;
    private Date tglLelang;
    private String golongan;
    private double sewaModal;
    private double tunggakan;
    private double admin;
    private double denda;
    private double charges;
    private double totalKewajiban;
    private double saldoEmas;
    private double saldoNominal;

    /**
     * GADAI 	: Jika Cicil Maka = Nilai Cicil
     * MIKRO 	: Jumlah Angsuran / Angsuran + Tunggakan
     * TABUNGAN	: Nilai Gram yang Ditabung Atau di BuyBack
     */
    private double nilaiTransaksi;
    private double harga; // emas
    private double gram; // emas
    private double satuan; // emas
    private String struk;
    private String rekeningPendamping;
    private double saldoRekeningPendamping;
    private double hakNasabah; // Gadai MT atau BuyBack
    private Date tglBuka; // Tgl Buka Rekening Tabungan
    private Date tglTransaksi;
    private double angsuranPerBulan;
    private double minimalUpCicil;

    private Integer angsuranKe;
    private Integer jumlahAngsuran;

    public TblLRestLogEChannel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 50)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "client_id", length = 10, nullable = false)
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Column(name = "channel_id", length = 10, nullable = false)
    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_request", length = 29)
    public Date getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(Date timeRequest) {
        this.timeRequest = timeRequest;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_response", length = 29)
    public Date getTimeResponse() {
        return timeResponse;
    }

    public void setTimeResponse(Date timeResponse) {
        this.timeResponse = timeResponse;
    }

    @Column(name = "response_code", length = 6)
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @Column(name = "response_desc", length = 255)
    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    @Column(name = "bill_key1", length = 25)
    public String getBillKey1() {
        return billKey1;
    }

    public void setBillKey1(String billKey1) {
        this.billKey1 = billKey1;
    }

    @Column(name = "bill_key2", length = 25)
    public String getBillKey2() {
        return billKey2;
    }

    public void setBillKey2(String billKey2) {
        this.billKey2 = billKey2;
    }

    @Column(name = "bill_key3", length = 25)
    public String getBillKey3() {
        return billKey3;
    }

    public void setBillKey3(String billKey3) {
        this.billKey3 = billKey3;
    }

    @Column(name = "request_type", length = 30)
    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @Column(name = "reff_switching", length = 30)
    public String getReffSwitching() {
        return reffSwitching;
    }

    public void setReffSwitching(String reffSwitching) {
        this.reffSwitching = reffSwitching;
    }

    @Column(name = "reff_core", length = 30)
    public String getReffCore() {
        return reffCore;
    }

    public void setReffCore(String reffCore) {
        this.reffCore = reffCore;
    }

    @Column(name = "product_name", length = 50)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "customer_name", length = 60)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_kredit", length = 13)
    public Date getTglKredit() {
        return tglKredit;
    }

    public void setTglKredit(Date tglKredit) {
        this.tglKredit = tglKredit;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_jatuh_tempo", length = 13)
    public Date getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(Date tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    @Column(name = "jml_hari_tarif", length = 20)
    public String getJmlHariTarif() {
        return jmlHariTarif;
    }

    public void setJmlHariTarif(String jmlHariTarif) {
        this.jmlHariTarif = jmlHariTarif;
    }

    @Column(name = "jml_hari_real", length = 10)
    public String getJmlHariReal() {
        return jmlHariReal;
    }

    public void setJmlHariReal(String jmlHariReal) {
        this.jmlHariReal = jmlHariReal;
    }

    @Column(name = "tenor", length = 15)
    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lelang", length = 13)
    public Date getTglLelang() {
        return tglLelang;
    }

    public void setTglLelang(Date tglLelang) {
        this.tglLelang = tglLelang;
    }

    @Column(name = "golongan", length = 10)
    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    @Column(name = "sewa_modal", precision = 17, scale = 17)
    public double getSewaModal() {
        return sewaModal;
    }

    public void setSewaModal(double sewaModal) {
        this.sewaModal = sewaModal;
    }

    @Column(name = "admin", precision = 17, scale = 17)
    public double getAdmin() {
        return admin;
    }

    public void setAdmin(double admin) {
        this.admin = admin;
    }

    @Column(name = "denda", precision = 17, scale = 17)
    public double getDenda() {
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }

    @Column(name = "charges", precision = 17, scale = 17)
    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    @Column(name = "total_kewajiban", precision = 17, scale = 17)
    public double getTotalKewajiban() {
        return totalKewajiban;
    }

    public void setTotalKewajiban(double totalKewajiban) {
        this.totalKewajiban = totalKewajiban;
    }

    @Column(name = "saldo_emas", precision = 17, scale = 17)
    public double getSaldoEmas() {
        return saldoEmas;
    }

    public void setSaldoEmas(double saldoEmas) {
        this.saldoEmas = saldoEmas;
    }

    @Column(name = "saldo_nominal", precision = 17, scale = 17)
    public double getSaldoNominal() {
        return saldoNominal;
    }

    public void setSaldoNominal(double saldoNominal) {
        this.saldoNominal = saldoNominal;
    }

    @Column(name = "struk", length = 999)
    public String getStruk() {
        return struk;
    }

    public void setStruk(String struk) {
        this.struk = struk;
    }

    @Column(name = "up", precision = 17, scale = 17)
    public double getUp() {
        return up;
    }

    public void setUp(double up) {
        this.up = up;
    }

    @Column(name = "sisa_up", precision = 17, scale = 17)
    public double getSisaUp() {
        return sisaUp;
    }

    public void setSisaUp(double sisaUp) {
        this.sisaUp = sisaUp;
    }

    @Column(name = "sisa_tenor", length = 15)
    public String getSisaTenor() {
        return sisaTenor;
    }

    public void setSisaTenor(String sisaTenor) {
        this.sisaTenor = sisaTenor;
    }

    @Column(name = "tunggakan", precision = 17, scale = 17)
    public double getTunggakan() {
        return tunggakan;
    }

    public void setTunggakan(double tunggakan) {
        this.tunggakan = tunggakan;
    }

    @Column(name = "rekening_pendamping", length = 16)
    public String getRekeningPendamping() {
        return rekeningPendamping;
    }

    public void setRekeningPendamping(String rekeningPendamping) {
        this.rekeningPendamping = rekeningPendamping;
    }

    @Column(name = "nilai_transaksi", precision = 17, scale = 17)
    public double getNilaiTransaksi() {
        return nilaiTransaksi;
    }

    public void setNilaiTransaksi(double nilaiTransaksi) {
        this.nilaiTransaksi = nilaiTransaksi;
    }

    @Column(name = "gram", precision = 17, scale = 17)
    public double getGram() {
        return gram;
    }

    public void setGram(double gram) {
        this.gram = gram;
    }

    @Column(name = "saldo_rek_pendamping", precision = 17, scale = 17)
    public double getSaldoRekeningPendamping() {
        return saldoRekeningPendamping;
    }

    public void setSaldoRekeningPendamping(double saldoRekeningPendamping) {
        this.saldoRekeningPendamping = saldoRekeningPendamping;
    }

    @Column(name = "hak_nasabah", precision = 17, scale = 17)
    public double getHakNasabah() {
        return hakNasabah;
    }

    public void setHakNasabah(double hakNasabah) {
        this.hakNasabah = hakNasabah;
    }

    @Column(name = "harga", precision = 17, scale = 17)
    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Column(name = "satuan", precision = 17, scale = 17)
    public double getSatuan() {
        return satuan;
    }

    public void setSatuan(double satuan) {
        this.satuan = satuan;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_buka", length = 13)
    public Date getTglBuka() {
        return tglBuka;
    }

    public void setTglBuka(Date tglBuka) {
        this.tglBuka = tglBuka;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_transaksi", length = 13)
    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    @Column(name = "angsuran_perbulan", precision = 17, scale = 17)
    public double getAngsuranPerBulan() {
        return angsuranPerBulan;
    }

    public void setAngsuranPerBulan(double angsuranPerBulan) {
        this.angsuranPerBulan = angsuranPerBulan;
    }

    @Column(name = "minimal_up_cicil", precision = 17, scale = 17)
    public double getMinimalUpCicil() {
        return minimalUpCicil;
    }

    public void setMinimalUpCicil(double minimalUpCicil) {
        this.minimalUpCicil = minimalUpCicil;
    }

    @Column(name = "angsuran_ke", length = 3)
    public Integer getAngsuranKe() {
        return angsuranKe;
    }

    public void setAngsuranKe(Integer angsuranKe) {
        this.angsuranKe = angsuranKe;
    }

    @Column(name = "jumlah_angsuran", length = 3)
    public Integer getJumlahAngsuran() {
        return jumlahAngsuran;
    }

    public void setJumlahAngsuran(Integer jumlahAngsuran) {
        this.jumlahAngsuran = jumlahAngsuran;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
