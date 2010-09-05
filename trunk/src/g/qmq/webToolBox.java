package g.qmq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class webToolBox {
	

	public webToolBox() {
	}
	/**
	 * ����Post��������
	 * @param url string ���ӵ�ַ
	 * @param cont String[] Post����(����,ֵ�������)
	 * @return �Ƿ�ɹ���ȡ����
	 */
	public boolean webCon(String url, String[] cont) {
		/* ����HTTPost���� */
		HttpPost httpRequest = new HttpPost(url);
		/* NameValuePairʵ����������ķ�װ */
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		//���밲ȫ��
		params.add(new BasicNameValuePair("sCode", sCode));
		//����POST����
		for(int i=0,tSize=cont.length;i<tSize-1;i++){
			params.add(new BasicNameValuePair(cont[i++],cont[i]));
			Log.v("POST", cont[i-1]);
			Log.v("POST", cont[i]);
		}
		try {
			/* ������������������� */
			httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			/* �������󲢵ȴ���Ӧ */
			HttpResponse httpResponse = new DefaultHttpClient()
					.execute(httpRequest);
			/* ��״̬��Ϊ200 ok */
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				/* ����������(����Post���ҳ��Դ��.) */
				strResult = EntityUtils.toString(httpResponse.getEntity(), "utf_8");
				Log.v("WebReturn", strResult);
				return true;
			} else {
				errMsg = "Error: "
						+ httpResponse.getStatusLine().toString();
				return false;
			}
		} catch (ClientProtocolException e) {
			errMsg = e.getMessage().toString();
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			errMsg = e.getMessage().toString();
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			errMsg = e.getMessage().toString();
			e.printStackTrace();
			return false;
		}
	}
	public String errMsg = null, strResult;
	public int myRank;
	
	private final static String sCode = "9EB2F1619156C86DD91C5652516F175E";
}
