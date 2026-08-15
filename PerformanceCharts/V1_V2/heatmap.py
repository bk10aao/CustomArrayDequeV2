import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Load data files
v1_df = pd.read_csv('CustomArrayDequeV1_jmh_performance_pivoted.csv', sep=';')
v2_df = pd.read_csv('CustomArrayDequeV2_jmh_performance_pivoted.csv', sep=';')

# Clean columns
v1_df.columns = [c.replace('"', '').strip() for c in v1_df.columns]
v2_df.columns = [c.replace('"', '').strip() for c in v2_df.columns]

sizes = v1_df['Size'].tolist()
methods = [c for c in v1_df.columns if c != 'Size']

heatmap_data = np.zeros((len(methods), len(sizes)))
text_labels = []

for i, m in enumerate(methods):
    row_labels = []
    for j, size in enumerate(sizes):
        v1_val = v1_df.loc[v1_df['Size'] == size, m].values[0]
        v2_val = v2_df.loc[v2_df['Size'] == size, m].values[0]

        # Avoid division by zero
        if v1_val == 0:
            v1_val = 1
        if v2_val == 0:
            v2_val = 1

        # Positive = V2 faster (lower ns/op)
        ratio = np.log2(v1_val / v2_val)
        heatmap_data[i, j] = ratio

        if v2_val <= v1_val:          # V2 faster or equal
            factor = v1_val / v2_val
            prefix = "+"
        else:                         # V1 faster
            factor = v2_val / v1_val
            prefix = "-"

        if factor >= 100:
            row_labels.append(f"{prefix}{factor:.0f}x")
        else:
            row_labels.append(f"{prefix}{factor:.1f}x")
    text_labels.append(row_labels)

text_labels = np.array(text_labels)

# Sort methods by average performance ratio (most V2-advantage at top)
avg_ratios = np.mean(heatmap_data, axis=1)
sorted_idx = np.argsort(avg_ratios)[::-1]   # descending so V2 wins appear first
heatmap_data = heatmap_data[sorted_idx]
text_labels = text_labels[sorted_idx]
sorted_methods = [methods[idx] for idx in sorted_idx]

# Plotting the heatmap
fig, ax = plt.subplots(figsize=(16, 14), facecolor='none')
ax.set_facecolor('none')

# Clip data at [-4.0, 4.0] (up to 16x) to preserve visualization detail
clipped_data = np.clip(heatmap_data, -4.0, 4.0)

cmap = sns.diverging_palette(15, 240, as_cmap=True)

sns.heatmap(
    clipped_data,
    annot=text_labels,
    fmt="",
    cmap=cmap,
    center=0,
    xticklabels=sizes,
    yticklabels=sorted_methods,
    ax=ax,
    cbar_kws={
        'label': '← V1 Faster | Relative Speedup Scale | V2 Faster →'
    },
    linewidths=0.6,
    linecolor='#444444',
    annot_kws={'size': 9, 'weight': 'bold'}
)

ax.set_title(
    'CustomArrayDeque V1 vs V2 Performance Comparison Matrix\n'
    '(Positive/Blue = V2 Faster, Negative/Red = V1 Faster)',
    color='#ffffff', fontsize=16, fontweight='bold', pad=20
)

ax.set_ylabel('Deque Interface Methods', color='#aaaaaa', fontsize=13, labelpad=10)
ax.set_xlabel('Collection Size (Elements)', color='#aaaaaa', fontsize=13, labelpad=10)

ax.tick_params(colors='#ffffff', labelsize=11)
plt.xticks(rotation=45)
plt.yticks(rotation=0)

cbar = ax.collections[0].colorbar
cbar.ax.tick_params(colors='#ffffff', labelsize=10)
cbar.ax.yaxis.label.set_color('#ffffff')
cbar.ax.yaxis.label.set_fontsize(12)

plt.tight_layout()
plt.savefig('heatmap.png', dpi=300, transparent=True)
plt.close()

print("CustomArrayDeque V1 vs V2 performance heatmap generated successfully!")
print("Min log2 ratio:", np.min(heatmap_data))
print("Max log2 ratio:", np.max(heatmap_data))
print("Sorted methods (V2 advantage → V1 advantage):", sorted_methods)