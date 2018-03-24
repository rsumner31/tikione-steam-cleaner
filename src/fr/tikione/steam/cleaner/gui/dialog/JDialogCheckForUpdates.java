package fr.tikione.steam.cleaner.gui.dialog;

import fr.tikione.steam.cleaner.Version;
import fr.tikione.steam.cleaner.util.GraphicsUtils;
import fr.tikione.steam.cleaner.util.Translation;
import fr.tikione.steam.cleaner.util.UpdateManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Check for updates window.
 */
@SuppressWarnings("serial")
public class JDialogCheckForUpdates extends JDialog {

    private Translation translation;

    /**
     * Create new form JDialogCheckForUpdates.
     *
     * @param parent the parent component.
     * @param modal indicates if the frame is modal.
     * @param translation the program language translation handler.
     */
    @SuppressWarnings({"CallToThreadStartDuringObjectConstruction", "LeakingThisInConstructor"})
    public JDialogCheckForUpdates(java.awt.Frame parent, boolean modal, final Translation translation) {
        super(parent, modal);
        initComponents();
        initTranslateComponents(translation);
        this.translation = translation;
        GraphicsUtils.setFrameCentered(this);
        jButtonDownload.setVisible(false);
        jLabelMessage.setText(translation.getString(Translation.SEC_WCHECKFORUPDATES, "info.check.working"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                String latestVersion = UpdateManager.getLatestVersion();
                StringBuilder message = new StringBuilder(256);
                message.append("<html><body>")
                        .append(translation.getString(Translation.SEC_WCHECKFORUPDATES, "info.yourVersion").replace(
                        "{0}", Version.VERSION))
                        .append("<br>")
                        .append(translation.getString(Translation.SEC_WCHECKFORUPDATES, "info.latestVersion").replace(
                        "{0}", UpdateManager.normalizeVersionStr(latestVersion)));
                if (latestVersion.equalsIgnoreCase(translation.getString(Translation.SEC_WCHECKFORUPDATES, "error.contact.url"))) {
                    message.append("</body></html>");
                    jButtonDownload.setVisible(false);
                } else {
                    message.append("<br><br>");
                    if (UpdateManager.IsUpToDate(latestVersion)) {
                        message.append(translation.getString(Translation.SEC_WCHECKFORUPDATES, "info.alreadyUpToDate"));
                        jButtonDownload.setVisible(false);
                    } else {
                        message.append(translation.getString(Translation.SEC_WCHECKFORUPDATES, "info.updateAvailable"));
                        jButtonDownload.setVisible(true);
                    }
                    message.append("</body></html>");
                }
                jLabelMessage.setText(message.toString());
            }
        }).start();
    }

    private void initTranslateComponents(Translation translation) {
        setTitle(translation.getString(Translation.SEC_WCHECKFORUPDATES, "frameTitle"));
        jButtonDownload.setText(translation.getString(Translation.SEC_WCHECKFORUPDATES, "button.downloadLatestVersion"));
        jButtonClose.setText(translation.getString(Translation.SEC_WCHECKFORUPDATES, "button.close"));
        jButtonDownload.setText(translation.getString(Translation.SEC_WCHECKFORUPDATES, "button.download"));
        jButtonChangelog.setText(translation.getString(Translation.SEC_WCHECKFORUPDATES, "button.changelog"));
    }

    /** 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabelMessage = new JLabel();
        jButtonClose = new JButton();
        jButtonDownload = new JButton();
        jSeparator = new JSeparator();
        jButtonChangelog = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new Color(255, 255, 255));

        jLabelMessage.setHorizontalAlignment(SwingConstants.LEFT);
        jLabelMessage.setVerticalAlignment(SwingConstants.TOP);
        jLabelMessage.setHorizontalTextPosition(SwingConstants.LEFT);
        jLabelMessage.setVerticalTextPosition(SwingConstants.TOP);

        jButtonClose.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        jButtonClose.setText("Close");
        jButtonClose.setFocusable(false);
        jButtonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonDownload.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        jButtonDownload.setForeground(new Color(0, 0, 102));
        jButtonDownload.setText("Download the latest version");
        jButtonDownload.setFocusable(false);
        jButtonDownload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonDownloadActionPerformed(evt);
            }
        });

        jButtonChangelog.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        jButtonChangelog.setText("Changelog");
        jButtonChangelog.setFocusable(false);
        jButtonChangelog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonChangelogActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jLabelMessage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonDownload)
                        .addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(jButtonChangelog)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jButtonClose))
                    .addComponent(jSeparator))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMessage, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonDownload)
                    .addComponent(jButtonChangelog))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonDownloadActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDownloadActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                String btnText = jButtonDownload.getText();
                jButtonDownload.setText("working...");
                jButtonDownload.setEnabled(false);
                if (!UpdateManager.downloadLatestAppVersion()) {
                    JOptionPane.showMessageDialog(null,
                            translation.getString(Translation.SEC_WCHECKFORUPDATES, "dialog.cantdownload.message.part1") + "\n"
                            + translation.getString(Translation.SEC_WCHECKFORUPDATES, "dialog.cantdownload.message.part2"),
                            translation.getString(Translation.SEC_WCHECKFORUPDATES, "dialog.cantdownload.title"),
                            JOptionPane.INFORMATION_MESSAGE);
                    UpdateManager.extBrowserGetLatestVersion();
                } else {
                    JOptionPane.showMessageDialog(null,
                            translation.getString(Translation.SEC_WCHECKFORUPDATES, "dialog.downloadok.message"),
                            translation.getString(Translation.SEC_WCHECKFORUPDATES, "dialog.downloadok.title"),
                            JOptionPane.INFORMATION_MESSAGE);
                }
                jButtonDownload.setText(btnText);
                jButtonDownload.setEnabled(true);
            }
        }).start();
    }//GEN-LAST:event_jButtonDownloadActionPerformed

    private void jButtonChangelogActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonChangelogActionPerformed
        UpdateManager.extBrowserGetLatestChangelog();
    }//GEN-LAST:event_jButtonChangelogActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButtonChangelog;
    private JButton jButtonClose;
    private JButton jButtonDownload;
    private JLabel jLabelMessage;
    private JPanel jPanel1;
    private JSeparator jSeparator;
    // End of variables declaration//GEN-END:variables
}
