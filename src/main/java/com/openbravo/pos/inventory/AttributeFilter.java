//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2017 uniCenta & previous Openbravo POS works
//    https://unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.inventory;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ComboBoxValModel;
import com.openbravo.data.loader.*;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.reports.ReportEditorCreator;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author adrianromero
 */
public class AttributeFilter extends javax.swing.JPanel implements ReportEditorCreator {

    private SentenceList attsent;
    private ComboBoxValModel attmodel;

    /** Creates new form AttributeUseFilter */
    public AttributeFilter() {
        initComponents();
    }

    /**
     *
     * @param app
     */
    @Override
    public void init(AppView app) {

        attsent = new StaticSentence(app.getSession()
            , "SELECT ID, NAME FROM attribute ORDER BY NAME"
            , null
            , new SerializerRead() {@Override
 public Object readValues(DataRead dr) throws BasicException {
                return new AttributeInfo(dr.getString(1), dr.getString(2));
            }});
        attmodel = new ComboBoxValModel();
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void activate() throws BasicException {
        List a = attsent.list();
        attmodel = new ComboBoxValModel(a);
        attmodel.setSelectedFirst();
        jAttr.setModel(attmodel);
    }

    /**
     *
     * @return
     */
    @Override
    public SerializerWrite getSerializerWrite() {
        return SerializerWriteString.INSTANCE;
    }

    /**
     *
     * @return
     */
    @Override
    public Component getComponent() {
        return this;
    }

    /**
     *
     * @param l
     */
    public void addActionListener(ActionListener l) {
        jAttr.addActionListener(l);
    }

    /**
     *
     * @param l
     */
    public void removeActionListener(ActionListener l) {
        jAttr.removeActionListener(l);
    }

    /**
     *
     * @return
     * @throws BasicException
     */
    @Override
    public Object createValue() throws BasicException {
        AttributeInfo att = (AttributeInfo) attmodel.getSelectedItem();

        return att == null ? null : att.getId();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jAttr = new javax.swing.JComboBox();

        jLabel8.setText(AppLocal.getIntString("label.attribute")); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(110, 30));

        jAttr.setPreferredSize(new java.awt.Dimension(220, 30));
        jAttr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAttrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAttr, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jAttr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jAttrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAttrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAttrActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jAttr;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

}
