package com.sfa.model;

import javax.persistence.*;

@Table(name = "t_zichanfuzhai")
public class TZichanfuzhai {
    @Id
    @Column(name = "t_zcfz_id")
    private String tZcfzId;

    @Column(name = "t_com_id")
    private String tComId;

    @Column(name = "t_huobizijin")
    private String tHuobizijin;

    @Column(name = "t_yingshouzhangkuan")
    private String tYingshouzhangkuan;

    @Column(name = "t_gudingzichanyuanzhi")
    private String tGudingzichanyuanzhi;

    @Column(name = "t_leijizhejiu")
    private String tLeijizhejiu;

    @Column(name = "t_gudingzichanheji")
    private String tGudingzichanheji;

    @Column(name = "t_zichanheji")
    private String tZichanheji;

    /**
     * @return t_zcfz_id
     */
    public String gettZcfzId() {
        return tZcfzId;
    }

    /**
     * @param tZcfzId
     */
    public void settZcfzId(String tZcfzId) {
        this.tZcfzId = tZcfzId;
    }

    /**
     * @return t_com_id
     */
    public String gettComId() {
        return tComId;
    }

    /**
     * @param tComId
     */
    public void settComId(String tComId) {
        this.tComId = tComId;
    }

    /**
     * @return t_huobizijin
     */
    public String gettHuobizijin() {
        return tHuobizijin;
    }

    /**
     * @param tHuobizijin
     */
    public void settHuobizijin(String tHuobizijin) {
        this.tHuobizijin = tHuobizijin;
    }

    /**
     * @return t_yingshouzhangkuan
     */
    public String gettYingshouzhangkuan() {
        return tYingshouzhangkuan;
    }

    /**
     * @param tYingshouzhangkuan
     */
    public void settYingshouzhangkuan(String tYingshouzhangkuan) {
        this.tYingshouzhangkuan = tYingshouzhangkuan;
    }

    /**
     * @return t_gudingzichanyuanzhi
     */
    public String gettGudingzichanyuanzhi() {
        return tGudingzichanyuanzhi;
    }

    /**
     * @param tGudingzichanyuanzhi
     */
    public void settGudingzichanyuanzhi(String tGudingzichanyuanzhi) {
        this.tGudingzichanyuanzhi = tGudingzichanyuanzhi;
    }

    /**
     * @return t_leijizhejiu
     */
    public String gettLeijizhejiu() {
        return tLeijizhejiu;
    }

    /**
     * @param tLeijizhejiu
     */
    public void settLeijizhejiu(String tLeijizhejiu) {
        this.tLeijizhejiu = tLeijizhejiu;
    }

    /**
     * @return t_gudingzichanheji
     */
    public String gettGudingzichanheji() {
        return tGudingzichanheji;
    }

    /**
     * @param tGudingzichanheji
     */
    public void settGudingzichanheji(String tGudingzichanheji) {
        this.tGudingzichanheji = tGudingzichanheji;
    }

    /**
     * @return t_zichanheji
     */
    public String gettZichanheji() {
        return tZichanheji;
    }

    /**
     * @param tZichanheji
     */
    public void settZichanheji(String tZichanheji) {
        this.tZichanheji = tZichanheji;
    }
}