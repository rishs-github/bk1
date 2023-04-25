/* 
 * RTC AG, Copyright (c) 2015 
 * created 09.02.2015 by franczat 
 */
package ch.rtc.zvc.services.interfaces.eingang.zvav.type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Contains list of {@link BuZvc_PacsXmlAuftrag}.
 * 
 * @author franczat
 */
public class BuZvc_PacsXmlAuftraege implements Serializable
{
    private static final long serialVersionUID = -6952191670084413065L;
    
    private final List<BuZvc_PacsXmlAuftrag> m_auftraege;

    /**
     * @param auftraege
     */
    public BuZvc_PacsXmlAuftraege(List<BuZvc_PacsXmlAuftrag> auftraege)
    {
        m_auftraege = auftraege;
    }

    /**
     * @param auftrag
     */
    public BuZvc_PacsXmlAuftraege(BuZvc_PacsXmlAuftrag auftrag)
    {
        m_auftraege = Arrays.asList(auftrag);
    }

    /**
     * @return
     */
    public List<BuZvc_PacsXmlAuftrag> getAuftraege()
    {
        return m_auftraege;
    }

}
