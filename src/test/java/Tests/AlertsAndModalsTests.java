package Tests;

import PageObjects.AlertsAndModalsObjects.BootstrapAlerts;
import PageObjects.AlertsAndModalsObjects.BootstrapModals;
import PageObjects.AlertsAndModalsObjects.WindowPopupModal;
import PageObjects.ListBoxObjects.BootstrapListBox;
import PageObjects.ListBoxObjects.DataListFilter;
import TestComponents.BaseTest;
import org.testng.annotations.Test;


public class AlertsAndModalsTests extends BaseTest {

    @Test
    public void bootstrapAlertsTest(){
        //BOOTSTRAP ALERTS
        BootstrapAlerts bootstrapAlerts = landingPage.goToBootstrapAlerts();
        bootstrapAlerts.bootstrapAlerts();
    }

    @Test
    public void bootstrapModalsTest(){
        //BOOTSTRAP MODALS
        BootstrapModals bootstrapModals = landingPage.goToBootstrapModals();
        bootstrapModals.bootstrapModalsSingleModal();
        bootstrapModals.bootstrapModalsMultipleModal();
    }

    @Test
    public void windowPopupModalTest() throws InterruptedException {
        //WINDOW POPUP MODAL
        WindowPopupModal windowPopupModal = landingPage.goToWindowPopupModal();
        windowPopupModal.windowPopupModal();
    }
}
