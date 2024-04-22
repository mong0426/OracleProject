package awtLogin;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
	private Frame f;
	private TextField tfId, tfPwd, tfMsg;
	private Button btn;
	private InfoDAO dao;
	ArrayList<InfoVo> list;
		
	
	public Main() {
		dao = new InfoDAO();
		
		f=new Frame("Login");
		f.setSize(410,200);
		f.setLayout(null);

		Label lid = new Label("ID");
		lid.setLocation(20,40);
		lid.setSize(50,50);
		Label lpwd = new Label("PWD");
		lpwd.setLocation(20,80);
		lpwd.setSize(50,50);
		
		tfId = new TextField(10);
		tfId.setLocation(100, 50);
		tfId.setSize(200, 30);
		
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');
		tfPwd.setLocation(100, 90);
		tfPwd.setSize(200, 30);
		
		tfMsg = new TextField(10);
		tfMsg.setLocation(50, 130);
		tfMsg.setSize(250, 30);
		
		btn = new Button("Login");
		btn.setLocation(310, 50);
		btn.setSize(80, 110);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(tfId.getText() + " : " + tfPwd.getText());
				String id = tfId.getText();
				
				list = dao.list(id);
				
				if(list.size() != 0) {
					for(int i = 0; i < list.size(); i++) {
						InfoVo data = (InfoVo) list.get(i);
						String gid = data.getId();
						String gpwd = data.getPwd();
						
						System.out.println(gid + " :: " + gpwd);
						
						if(tfId.getText().equals(gid) && tfPwd.getText().equals(gpwd)) {
							tfMsg.setText("로그인이 성공했습니다.");
						} else {
							tfMsg.setText("로그인이 실패했습니다.");
						}
					}
				}else {
					tfMsg.setText("로그인이 실패했습니다.");
				}
				
				for (int i = 0; i < list.size(); i++) {
					InfoVo data = (InfoVo) list.get(i);
					String gid = data.getId();
					String gpwd = data.getPwd();
					
					System.out.println(gid + " :: " + gpwd);
				}
				
				
			}
			
		});

		f.add(lid);
		f.add(tfId);
		f.add(lpwd);
		f.add(tfPwd);
		f.add(tfMsg);
		f.add(btn);
		
		f.setVisible(true);
		
		
		
		}
		
	

	public static void main(String[] args) {

		new Main();

	}

}
