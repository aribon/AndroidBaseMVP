# AndroidBaseMVP

AndroidBaseMVP it's a basic library using [MVP](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) pattern.

## Usage

### Manually implementation

This way allows to keep control on the presenter creation. In fact, presenter not link with Activity/Fragment lifecycle.  

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
			...
			presenter.onDestroy();
			super.onDestroy();
		}
	}
	```

### Automatic implementation

To use this way, you must extends your Activity/Fragment with `BaseActivity`, `BaseFragment` or `BaseSupportFragment`.
These class allows to create and link automatically the presenter and the view. In fact, all lifecycle methods in your activity will be linked with the presenter.

:warning: In this way, all `public` methods in your Activity/Fragment will be accesible from your `CustomPresenter`

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
	public class CustomActivity extends BaseActivity<CustomPresenter> implements CustomView {
		...
	}
	```

#License

	Copyright 2016 Ribon Anthony

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
