package mods.nazu.ncraft;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public class CommonProxy
{
    public void addNames()
    {
        String langDir = "/mods/ncraft/lang/";
        String[] langs = { "en_US.xml" };

        for (String lang : langs)
        {
            try
            {
                LanguageRegistry.instance().loadLocalization(
                    langDir + lang,
                    lang.substring(lang.lastIndexOf('/') + 1, lang.lastIndexOf('.')),
                    true
                );
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
