package fojo.client.test;

import org.apache.http.HttpResponse;

import fojo.client.MainActivity;
import fojo.client.net.FojoAPI;
import fojo.client.net.FojoEntry;
import android.test.ActivityInstrumentationTestCase2;

public class TestFojoJavaClient extends
		ActivityInstrumentationTestCase2<MainActivity> {
	
	private FojoAPI fojoApi;

	public TestFojoJavaClient() {
		super("fojo.client", MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.fojoApi = FojoAPI.getInstance();
	}

	public void testFojoEntry() {
		try {
			FojoEntry e = new FojoEntry(1, "beer");
			assertEquals(e.getDescription(), "beer");
			HttpResponse resp = this.fojoApi.sendPostRequest(e);
			assertEquals(201, resp.getStatusLine().getStatusCode());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
