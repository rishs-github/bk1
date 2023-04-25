/* 
 * RTC AG, Copyright (c) 2015 
 * created 09.02.2015 by franczat 
 */
package ch.rtc.zvc.services.interfaces.eingang.zvav.type;

import ch.rtc.infra.bdv.type.InBdv_Zahlungsweg;

import java.io.Serializable;

/**
 * Contains an auftrag in pacs xml format and zahlungsweg.
 * 
 * @author franczat
 */
public class BuZvc_PacsXmlAuftrag implements Serializable
{
    private static final long serialVersionUID = -8694781426219384523L;

    private final String m_auftrag;

    private final InBdv_Zahlungsweg m_zahlungsweg;

    /**
     * @param auftrag
     * @param inBdv_ZahlungsauftragsTyp
     */
    public BuZvc_PacsXmlAuftrag(String auftrag, InBdv_Zahlungsweg zahlungsweg)
    {
        m_auftrag = auftrag;
        m_zahlungsweg = zahlungsweg;
    }

    /**
     * @return
     */
    public String getAuftrag()
    {
        return m_auftrag;
    }

    /**
     * @return
     */
    public InBdv_Zahlungsweg getZahlungsweg()
    {
        return m_zahlungsweg;
    }

    @Override
    public String toString()
    {
        return String.format("Zahlungs weg: %s \nAuftrag: %s", m_zahlungsweg, m_auftrag);
    }

}
