package example.android.optionmenusample;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class OptionMenuSampleActivity extends Activity {

	private static final int REQUEST_IMAGE_CAPTURE = 0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option_menu_sample);
	}

	// onCreateOptionsMenu���\�b�h(�I�v�V�������j���[����)
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//If you want add the menuButton without xmlFile, Call the super class.
		super.onCreateOptionsMenu(menu);

		//Add MenuItems
		//((group_number),(Identifier of each item),(Order to be displayed),(Item_name))
		MenuItem item1 =menu.add(0,0,0,"Save");
		item1.setIcon(android.R.drawable.ic_menu_save);
		MenuItem item2 =menu.add(0,1,0,"Camera");
		item2.setIcon(android.R.drawable.ic_menu_camera);
		MenuItem item3 =menu.add(0,2,0,"Location");
		item3.setIcon(android.R.drawable.ic_menu_mylocation);
		MenuItem item4 =menu.add(0,3,0,"Massage");
		item4.setIcon(android.R.drawable.ic_dialog_email);
		MenuItem item5 =menu.add(0,4,0,"Map");
		item5.setIcon(android.R.drawable.ic_dialog_map);

		//
		SubMenu item6 =menu.addSubMenu(0,5,0,"Others");
		item6.setIcon(android.R.drawable.ic_menu_gallery);
		item6.add(0, 10, 0, "subitem1");
		item6.add(0, 20, 0, "subitem2");



		getMenuInflater().inflate(R.menu.activity_option_menu_sample, menu);
		return true;
	}

		// onOptionsItemSelected���\�b�h(���j���[�A�C�e���I������)
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			String action = null;
			switch (item.getItemId()) {
				case 0:
					showDialog("Saved !");
					return true;
				case 1:
					/*showDialog("Selected Camera !");*/
					startCamera();

					return true;
				case 2:

					return true;
				case 3:
					// �C���e���g�̃C���X�^���X����
					Intent intent = new Intent();
					// �C���e���g�ɃA�N�V�����y�ё��M�����Z�b�g
					intent.setAction(Intent.ACTION_SENDTO);
					intent.setData(Uri.parse("mailto:xxx@gmail.com"));
					intent.putExtra(Intent.EXTRA_SUBJECT, "TEST");
					intent.putExtra(Intent.EXTRA_TEXT, "����̓e�X�g���[���ł�.");
			// ���[���N��
			startActivity(intent);
					return true;
				case 4:
					showDialog("Selected Map");
					return true;
				case 10:
					showDialog("Selected sub1");
					return true;
				case 20:
					showDialog("Selected sub2");
					return true;
				default:
					return super.onOptionsItemSelected(item);
			}
		}

		public void startCamera() {
		// �J�����A�v�����N������
		Intent intent = new Intent();// �C���e���g�̃C���X�^���X
		intent.setAction("android.media.action.IMAGE_CAPTURE");// �C���e���g�ɃA�N�V�������Z�b�g����
		startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);// �J�����A�v���N������

	}


		// showDialog���\�b�h(�_�C�A���O�\��)
		private void showDialog(String text) {
			AlertDialog.Builder dialog
					=new AlertDialog.Builder(OptionMenuSampleActivity.this);
			dialog.setTitle("���j���[�A�C�e���I������");
			dialog.setMessage(text);
			dialog.setPositiveButton("OK",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int whichButton) {
					OptionMenuSampleActivity.this.setResult(Activity.RESULT_OK);
				}
			});
			dialog.create();
			dialog.show();
		}



	}

