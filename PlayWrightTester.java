package test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import java.util.HashMap;
import java.util.Map;

public class PlayWrightTester {

    public static void main(String[] args) {
        Map<String, String> env = new HashMap<String, String>();
        env.put("DEBUG", "pw:api");
        try (Playwright pw = Playwright.create(new Playwright.CreateOptions().setEnv(env))) {
            Browser b = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            BrowserContext c = b.newContext();
            Page p = c.newPage();
            String url = "https://www.morningstar.co.uk/Common/funds/snapshot/PortfolioSAL.aspx?Site=uk&FC=F0GBR04SA0&IT=FO&LANG=en-GB";
            p.navigate(url);
            p.waitForLoadState(LoadState.LOAD);
            String selector = ".sal-holdings__leftTable > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1)";
            ElementHandle eh = p.querySelector(selector);
            System.out.println(eh);
            b.close();
        }
    }

}
