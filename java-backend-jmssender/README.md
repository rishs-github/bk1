users for ch.rtc.zvc.unifi.payment.q (queueId="ZVAV_EINGANG"):
 - shall have:
        ROLE_AUSFUEHREN_ZVA_ZAHLUNG or
        ROLE_AUSFUEHREN_RZ_VERARBEITUNG
 - shall have at least one of:
       ROLE_AUSFUEHREN_ZVA_UEBERTRAG
       ROLE_AUSFUEHREN_ZVA_ZAHLUNG
       ROLE_AUSFUEHREN_RZ_VERARBEITUNG

user: RZPW2 -> ok
user: RZZA1 -> C_EINGANGSKANAL='Unifi-Pain-Inhouse'
user: RZZB1 -> ?
user: RSC05 -> C_EINGANGSKANAL='Unifi-Pain-Inhouse'
user: TUS05 -> C_EINGANGSKANAL='Unifi-Pain-Inhouse'


set in config file

refer to author for config file: java\resources\com.hp.bsc.testing.jmssender-config.xml

