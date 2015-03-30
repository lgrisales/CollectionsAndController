import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class GuiOrderCollection {

	private JFrame frame;
	private String alpha;
	private JList list;
	Controller ctller = new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiOrderCollection window = new GuiOrderCollection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiOrderCollection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Lab 9-By Lina Grisales");
		frame.setBounds(100, 100, 673, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		list = new JList();
		frame.getContentPane().add(list, BorderLayout.WEST);
		list.setListData(ctller.getFruits());

		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu mnSortby_1 = new JMenu("SortBy:");
		menuBar.add(mnSortby_1);

		JMenuItem mntmIndexOfI = new JMenuItem("Index of i");

		mntmIndexOfI.addActionListener(new ActionListener() {// sort by
					public void actionPerformed(ActionEvent e) {
						SortByIndexOfi sIndex = new SortByIndexOfi();

						Iterator<String> iter = ctller.resort(sIndex);

						DefaultListModel<String> listModel = new DefaultListModel<String>();
						while (iter.hasNext()) {
							listModel.addElement(iter.next());
						}

						list.setModel(listModel);
					}

				});

		mnSortby_1.add(mntmIndexOfI);

		JMenuItem mntmLenght = new JMenuItem("Length");
		mntmLenght.addActionListener(new ActionListener() {// sort by

					public void actionPerformed(ActionEvent arg0) {
						SortByLength sLength = new SortByLength();

						Iterator<String> iter = ctller.resort(sLength);

						DefaultListModel<String> listModel = new DefaultListModel<String>();
						while (iter.hasNext()) {
							listModel.addElement(iter.next());
						}

						list.setModel(listModel);
					}
				});

		mnSortby_1.add(mntmLenght);

		JMenuItem mntmAlphabetical = new JMenuItem("Alphabetical");

		mntmAlphabetical.addActionListener(new ActionListener() {// sort by
					public void actionPerformed(ActionEvent e) {
						SortAlphabetical alpha = new SortAlphabetical();
						Iterator<String> iter = ctller.resort(alpha);
						DefaultListModel<String> listModel = new DefaultListModel<String>();
						while (iter.hasNext()) {
							listModel.addElement(iter.next());
						}

						list.setModel(listModel);
					}
				});

		mnSortby_1.add(mntmAlphabetical);

		JTextArea lblPleaseSelectAn = new JTextArea(
				"Welcome to the OrderBy items. Please select an option from the menu");
		frame.getContentPane().add(lblPleaseSelectAn);
		lblPleaseSelectAn.setEditable(false);
		JButton btnExit = new JButton("Exit");
		frame.getContentPane().add(btnExit, BorderLayout.SOUTH);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

			}
		});
		JMenu mnSortby = new JMenu("SortBy:");

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
