# AndroidBaseMVP
TODO: Write a project description

## Usage

### Manually instantiation
TODO: Write usage instructions

1. Create your custom view extending `BaseView`

	```java
	interface CustomView extends BaseView {
		...	
	}
	```
	
2. Create your custom `Presenter` extending `BasePresenter`

	```java
	public class CustomPresenter extends BasePresenter<CustomView> {
		...
	}
	```
	
3. Finally create your Activity/Fragment implementing your `CustomView`

	```java
	public class CustomFragment extends Fragment implements CustomView {
	
		private CustomPresenter presenter;
		...
		
		@Override
    	protected void onCreate(@Nullable Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			...
			presenter = new ManuallyLinkPresenter();
        	presenter.onAttachView(this);	
		}
		
		...
		
		@Override
    	public void onDestroy() {
			presenter.onDestroy();
			super.onDestroy();
		}
	}
	```

### Automatic instantiation
TODO: Write usage instructions

1. Create your custom view extending `BaseView`

	```java
	interface CustomView extends BaseView {
		...	
	}
	```
	
2. Create your custom `Presenter` extending `BasePresenter`

	```java
	public class CustomPresenter extends BasePresenter<CustomView> {
		...
	}
	```
	
3. Finally create your Activity/Fragment extending `BaseActivity`, `BaseFragment` or `BaseSupportFragment`

	```java
	public class CustomActivity extends Fragment extends BaseActivity<CustomPresenter> {
		...
	}
	```
