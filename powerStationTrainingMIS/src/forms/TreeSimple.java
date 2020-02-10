package forms;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import dto.DepartDTO;
import dto.HighDepartDTO;
import services.depart.Department;

public class TreeSimple {
	private JTree tree;

	private String selectStr;
	private JTree tree1;

	public TreeSimple(JPanel panel) {
		initialize(panel);
	}

	public void initialize(JPanel panel) {
		tree = new JTree();
		tree.setModel(
				new DefaultTreeModel(new DefaultMutableTreeNode("\u592A\u539F\u7B2C\u4E8C\u70ED\u7535\u5382\t\t") {
					{
						DefaultMutableTreeNode node;
						// 定义服务层
						Department depart = new Department();
						// 定义接受层
						List<HighDepartDTO> departAllDTO = new ArrayList<HighDepartDTO>();
						departAllDTO = depart.queryAllInfoHighByNo();
						for (int i = 0; i < departAllDTO.size(); i++) {
							if (departAllDTO.get(i).getHighDepartNumber() != null) {

								node = new DefaultMutableTreeNode(departAllDTO.get(i).getHighDepartName());

								findChildUnit(departAllDTO.get(i).getHighDepartNumber(), node);
								add(node);
							}
						}
					}
				}));
		tree.setBounds(0, 0, 185, 334);
		panel.add(tree);
	}

	public void findChildUnit(String highDepartNumber, DefaultMutableTreeNode node) {
		// 定义服务层
		Department childDepartInfo = new Department();
		// 定义传输层
		List<DepartDTO> departDTO = new ArrayList<DepartDTO>();
		departDTO = childDepartInfo.queryAllInfoChildByNo();
		for (int i = 0; i < departDTO.size(); i++) {
			if (departDTO.get(i).getHighDepartNumber().equals(highDepartNumber)) {
				node.add(new DefaultMutableTreeNode(departDTO.get(i).getDepartName()));
			}
		}
	}

	public String getSelectStr() {
		return selectStr;
	}

	public JTree getTree() {
		return tree;
	}
}
