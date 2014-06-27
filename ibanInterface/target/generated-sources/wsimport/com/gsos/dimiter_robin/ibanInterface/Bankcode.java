
package com.gsos.dimiter_robin.ibanInterface;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bankcode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="bankcode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ABNA"/>
 *     &lt;enumeration value="FTSB"/>
 *     &lt;enumeration value="AEGO"/>
 *     &lt;enumeration value="ANAA"/>
 *     &lt;enumeration value="ANDL"/>
 *     &lt;enumeration value="ARBN"/>
 *     &lt;enumeration value="ARSN"/>
 *     &lt;enumeration value="ARTE"/>
 *     &lt;enumeration value="ASNB"/>
 *     &lt;enumeration value="ASRB"/>
 *     &lt;enumeration value="ATBA"/>
 *     &lt;enumeration value="BBRU"/>
 *     &lt;enumeration value="BCDM"/>
 *     &lt;enumeration value="BCIT"/>
 *     &lt;enumeration value="BICK"/>
 *     &lt;enumeration value="BKCH"/>
 *     &lt;enumeration value="BKMG"/>
 *     &lt;enumeration value="BLGW"/>
 *     &lt;enumeration value="BMEU"/>
 *     &lt;enumeration value="BNGH"/>
 *     &lt;enumeration value="BNPA"/>
 *     &lt;enumeration value="BOFA"/>
 *     &lt;enumeration value="BOFS"/>
 *     &lt;enumeration value="BOTK"/>
 *     &lt;enumeration value="CHAS"/>
 *     &lt;enumeration value="CITC"/>
 *     &lt;enumeration value="CITI"/>
 *     &lt;enumeration value="COBA"/>
 *     &lt;enumeration value="DEUT"/>
 *     &lt;enumeration value="DHBN"/>
 *     &lt;enumeration value="DLBK"/>
 *     &lt;enumeration value="DNIB"/>
 *     &lt;enumeration value="FBHL"/>
 *     &lt;enumeration value="FLOR"/>
 *     &lt;enumeration value="FRBK"/>
 *     &lt;enumeration value="FRGH"/>
 *     &lt;enumeration value="FVLB"/>
 *     &lt;enumeration value="GILL"/>
 *     &lt;enumeration value="HAND"/>
 *     &lt;enumeration value="HHBA"/>
 *     &lt;enumeration value="HSBC"/>
 *     &lt;enumeration value="ICBK"/>
 *     &lt;enumeration value="INGB"/>
 *     &lt;enumeration value="INSI"/>
 *     &lt;enumeration value="ISBK"/>
 *     &lt;enumeration value="KABA"/>
 *     &lt;enumeration value="KASA"/>
 *     &lt;enumeration value="KNAB"/>
 *     &lt;enumeration value="KOEX"/>
 *     &lt;enumeration value="KRED"/>
 *     &lt;enumeration value="LOCY"/>
 *     &lt;enumeration value="LOYD"/>
 *     &lt;enumeration value="LPLN"/>
 *     &lt;enumeration value="MHCB"/>
 *     &lt;enumeration value="NNBA"/>
 *     &lt;enumeration value="NWAB"/>
 *     &lt;enumeration value="OVBN"/>
 *     &lt;enumeration value="RABO"/>
 *     &lt;enumeration value="RBOS"/>
 *     &lt;enumeration value="RBRB"/>
 *     &lt;enumeration value="SNSB"/>
 *     &lt;enumeration value="SOGE"/>
 *     &lt;enumeration value="STAL"/>
 *     &lt;enumeration value="TEBU"/>
 *     &lt;enumeration value="TRIO"/>
 *     &lt;enumeration value="UBSW"/>
 *     &lt;enumeration value="UGBI"/>
 *     &lt;enumeration value="VOWA"/>
 *     &lt;enumeration value="ZWLB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "bankcode")
@XmlEnum
public enum Bankcode {

    ABNA,
    FTSB,
    AEGO,
    ANAA,
    ANDL,
    ARBN,
    ARSN,
    ARTE,
    ASNB,
    ASRB,
    ATBA,
    BBRU,
    BCDM,
    BCIT,
    BICK,
    BKCH,
    BKMG,
    BLGW,
    BMEU,
    BNGH,
    BNPA,
    BOFA,
    BOFS,
    BOTK,
    CHAS,
    CITC,
    CITI,
    COBA,
    DEUT,
    DHBN,
    DLBK,
    DNIB,
    FBHL,
    FLOR,
    FRBK,
    FRGH,
    FVLB,
    GILL,
    HAND,
    HHBA,
    HSBC,
    ICBK,
    INGB,
    INSI,
    ISBK,
    KABA,
    KASA,
    KNAB,
    KOEX,
    KRED,
    LOCY,
    LOYD,
    LPLN,
    MHCB,
    NNBA,
    NWAB,
    OVBN,
    RABO,
    RBOS,
    RBRB,
    SNSB,
    SOGE,
    STAL,
    TEBU,
    TRIO,
    UBSW,
    UGBI,
    VOWA,
    ZWLB;

    public String value() {
        return name();
    }

    public static Bankcode fromValue(String v) {
        return valueOf(v);
    }

}
